package com.adviters.administracionusuarios.models.dtos.licencias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LicenciaNuevaDto {

    private Long solicitanteId;

    private String tipo;

    private String adjunto;

    private String fechaComienzo;

    private String fechaFinalizacion;

    private String descripcion;

    private Long supervisorId;
}
