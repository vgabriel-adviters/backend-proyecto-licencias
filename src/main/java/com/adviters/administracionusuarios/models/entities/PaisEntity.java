package com.adviters.administracionusuarios.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pais")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaisEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "pais", targetEntity = UserEntity.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<UserEntity> user;

}
