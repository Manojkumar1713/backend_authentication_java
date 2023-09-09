package com.example.loginRegister.demo.UserController;

import com.example.loginRegister.demo.dto.LoginDTO;
import com.example.loginRegister.demo.dto.UserDTO;
import com.example.loginRegister.demo.payload.LoginMessage;
import com.example.loginRegister.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/v1")
public class UserLoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public String testConnection(){
        System.out.println("Home Page");
        return "test";
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveUser(@RequestBody UserDTO userDTO){
        System.out.println("Test  "+userDTO.getEmail());
        String name = userService.addUser(userDTO);
        return ResponseEntity.ok(" User successfully registered !!");
    }
    // this comment from Rajashaker test

    @RequestMapping(path = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO dto){
        System.out.println("Test  "+dto.getEmail());
        LoginMessage message = userService.loginEmployee(dto);
        return ResponseEntity.ok(message);
    }
}
