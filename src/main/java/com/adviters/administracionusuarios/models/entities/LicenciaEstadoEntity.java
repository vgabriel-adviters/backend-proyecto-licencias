package com.adviters.administracionusuarios.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "licencias_estado")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LicenciaEstadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "activo")
    private boolean activo = true;

    @OneToMany(mappedBy = "estado")
    @JsonBackReference
    private List<LicenciaEntity> licencias;
}
