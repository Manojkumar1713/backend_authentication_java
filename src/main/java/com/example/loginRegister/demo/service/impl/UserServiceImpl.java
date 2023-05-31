package com.example.loginRegister.demo.service.impl;

import com.example.loginRegister.demo.dto.LoginDTO;
import com.example.loginRegister.demo.dto.UserDTO;
import com.example.loginRegister.demo.entity.UserEntity;
import com.example.loginRegister.demo.payload.LoginMessage;
import com.example.loginRegister.demo.repo.UserRepo;
import com.example.loginRegister.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserDTO dto) {
        UserEntity user = UserEntity.builder().firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .password(this.passwordEncoder.encode(dto.getPassword()))
                .build();

        userRepo.save(user);

        return user.getFirstName()+" "+user.getLastName();
    }

    @Override
    public LoginMessage loginEmployee(LoginDTO dto) {
        String msg = "";
        UserEntity user = userRepo.findByEmail(dto.getEmail());
        if(user != null){
            String pass = dto.getPassword();
            String encoded_pass = user.getPassword();
            boolean matchesPassword = passwordEncoder.matches(pass,encoded_pass);
            if(matchesPassword){
                Optional<UserEntity> userEntity = userRepo.findOneByEmailAndPassword(dto.getEmail(),encoded_pass);
                if(userEntity.isPresent()){
                    return new LoginMessage("Login Message", true);
                }
                else{
                    return new LoginMessage("Login Failed", false);
                }
            }
            else{
                return new LoginMessage("Password does not Match", false);
            }
        }
        else{
            return new LoginMessage("Email does not existis", false);
        }
    }
}
