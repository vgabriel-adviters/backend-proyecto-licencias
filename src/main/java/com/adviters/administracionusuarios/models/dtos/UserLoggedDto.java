package com.adviters.administracionusuarios.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoggedDto {

    private Long id;

    private String nombre;

    private String foto;

    private String rol;
}
