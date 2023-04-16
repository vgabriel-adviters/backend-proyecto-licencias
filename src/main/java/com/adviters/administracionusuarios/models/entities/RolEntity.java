package com.adviters.administracionusuarios.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rol")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

//    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
//    private Set<UserEntity> userEntities = new HashSet<>();
}
