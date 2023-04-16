package com.adviters.administracionusuarios.models.dtos;

import com.adviters.administracionusuarios.models.entities.RolEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    private String username;

    private String password;

//    private RolEntity rol;
}
