package com.adviters.administracionusuarios.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Locale;

@Entity
@Table(name = "licencias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LicenciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_tipo")
    private Long tipo;

    @Column(name = "id_estado")
    private Long estado;

    @Column(name = "adjunto")
    private Long adjunto;

    @Column(name = "fecha_peticion")
    private String fechaPeticion;

    @Column(name = "fecha_comienzo")
    private String fechaComienzo;

    @Column(name = "fecha_finalizacion")
    private String fechaFinalizacion;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "solicitante_id")
    private Long solicitante;
}
