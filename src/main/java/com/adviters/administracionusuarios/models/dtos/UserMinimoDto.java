package com.adviters.administracionusuarios.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMinimoDto {

    private Long idUsuario;

    private String username;

    private String apellido;
}
