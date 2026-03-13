package com.Projecto.Eric.TaskManager.Auth;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}