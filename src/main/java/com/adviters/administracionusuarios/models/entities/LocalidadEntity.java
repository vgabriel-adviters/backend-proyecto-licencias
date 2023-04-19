package com.adviters.administracionusuarios.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "localidades")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalidadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "localidad", targetEntity = UserEntity.class, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<UserEntity> users;

}
