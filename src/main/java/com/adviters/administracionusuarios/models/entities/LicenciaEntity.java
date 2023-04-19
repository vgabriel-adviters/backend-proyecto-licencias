package com.adviters.administracionusuarios.models.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "licencias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LicenciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "adjunto")
    private String adjunto;

    @Column(name = "fecha_peticion")
    private Date fechaPeticion;

    @Column(name = "fecha_comienzo")
    private Date fechaComienzo;

    @Column(name = "fecha_finalizacion")
    private Date fechaFinalizacion;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = UserEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "solicitante_id")
    @JsonManagedReference
    private UserEntity solicitante;

    @Column(name = "activo")
    private boolean activo = true;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = LicenciaTipoEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_id")
    @JsonManagedReference
    private LicenciaTipoEntity tipo;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = LicenciaEstadoEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_id")
    @JsonManagedReference
    private LicenciaEstadoEntity estado;
}
