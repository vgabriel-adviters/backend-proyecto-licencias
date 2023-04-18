package com.adviters.administracionusuarios.models.dtos.licencias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LicenciaMinimaDto {

    private Long id;

    private String tipo;

    private String estado;

    private String fechaComienzo;

    private String fechaFinalizacion;

    private Long solicitante;
}
