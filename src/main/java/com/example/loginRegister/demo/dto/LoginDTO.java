package com.example.loginRegister.demo.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    public String email;
    public String password;
}
