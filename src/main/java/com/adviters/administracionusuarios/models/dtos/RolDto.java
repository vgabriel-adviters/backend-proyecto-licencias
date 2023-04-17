package com.adviters.administracionusuarios.models.dtos;

import com.adviters.administracionusuarios.models.entities.RolEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolDto {

    private Long id;

    private String nombre;

}
