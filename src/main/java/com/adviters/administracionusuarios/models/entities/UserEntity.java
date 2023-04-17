package com.adviters.administracionusuarios.models.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;


    @OneToOne(targetEntity = RolEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="fk_id_rol")
    @JsonManagedReference
    private  RolEntity rol;

    @Column(name = "id_supervisor")
    private Long id_supervisor;

    @Column(name = "fecha_de_nacimiento")
    private String fecha_de_nacimiento;

    @Column(name = "fecha_de_ingreso")
    private String fecha_de_ingreso;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "dni")
    private String dni;

    @Column(name = "cuil")
    private String cuil;

    @Column(name = "dias_de_vacaciones")
    private String dias_de_vacaciones;

    @Column(name = "foto")
    private  String foto;















}
