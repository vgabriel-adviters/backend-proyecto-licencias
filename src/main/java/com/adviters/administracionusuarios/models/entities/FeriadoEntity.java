package com.adviters.administracionusuarios.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "feriados")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeriadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "motivo")
    private String motivo;
}
