package com.example.loginRegister.demo.service;

import com.example.loginRegister.demo.dto.LoginDTO;
import com.example.loginRegister.demo.dto.UserDTO;
import com.example.loginRegister.demo.payload.LoginMessage;

public interface UserService {
    String addUser(UserDTO dto);

    LoginMessage loginEmployee(LoginDTO dto);
}
