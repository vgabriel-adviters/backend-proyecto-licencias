package com.adviters.administracionusuarios.models.dtos.licencias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LicenciaNuevaDto {

    private String adjunto;

    private String fechaPeticion;

    private String fechaComienzo;

    private String fechaFinalizacion;

    private String descripcion;

    private Long solicitante;

    private String tipo;

    private String estado;
}
