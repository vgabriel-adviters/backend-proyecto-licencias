package com.adviters.administracionusuarios.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "provincia")
@Data
@AllArgsConstructor
public class ProvinciaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "provincia", targetEntity = UserEntity.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<UserEntity> user;

    public ProvinciaEntity(){
        this.user = new ArrayList<>();
    }

}
