package com.example.loginRegister.demo.payload;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginMessage {
    public String message;
    public boolean status;
}
