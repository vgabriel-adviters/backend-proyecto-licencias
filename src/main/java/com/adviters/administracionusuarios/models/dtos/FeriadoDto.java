package com.adviters.administracionusuarios.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeriadoDto {

    private String fecha;

    private String motivo;
}
