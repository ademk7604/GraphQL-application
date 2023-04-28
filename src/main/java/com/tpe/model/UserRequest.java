package com.tpe.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class UserRequest {
    private String username;
    private String mail;
    @Enumerated(EnumType.STRING)
    private Role rol;
}
