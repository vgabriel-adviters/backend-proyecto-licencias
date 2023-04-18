package com.adviters.administracionusuarios.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "licencias_tipo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LicenciaTipoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "activo")
    private boolean activo = true;

    @OneToMany(mappedBy = "tipo")
    @JsonBackReference
    private List<LicenciaEntity> licencias;
}
