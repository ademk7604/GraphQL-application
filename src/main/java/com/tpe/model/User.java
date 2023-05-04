package com.tpe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "`user`")
public class User extends BaseEntity {
    //h2 db de user -> reserved oldugu icin backtik icinde kullandik, kizmamasi icin :)

    private String username;
    private String mail;
    @Enumerated(EnumType.STRING)
    private Role rol;

}
