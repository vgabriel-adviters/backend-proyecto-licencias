package com.adviters.administracionusuarios.models.dtos.licencias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LicenciaFullDto {

    private Long id;

    private String tipo;

    private String estado;

    private String adjunto;

    private String fechaPeticion;

    private String fechaComienzo;

    private String fechaFinalizacion;

    private String descripcion;

    private Long solicitante;
}
