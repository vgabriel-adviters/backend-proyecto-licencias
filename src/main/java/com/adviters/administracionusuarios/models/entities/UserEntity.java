package com.adviters.administracionusuarios.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "clave")
    private String password;

    @Column(name = "id_supervisor")
    private Long id_supervisor;

    @Column(name = "fecha_de_nacimiento")
    private String fecha_de_nacimiento;

    @Column(name = "fecha_de_ingreso")
    private String fecha_de_ingreso;

    @Column(name = "dni")
    private String dni;

    @Column(name = "cuil")
    private String cuil;

    @Column(name = "dias_de_vacaciones")
    private String dias_de_vacaciones;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    @Column(name = "codigo_postal")
    private String codigo_postal;

    @Column(name = "foto")
    private String foto;

    @Column(name = "calle")
    private String calle;

    @Column(name = "altura")
    private Long altura;

    @Column(name = "torre")
    private String torre;

    @Column(name = "piso")
    private int piso;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "activo")
    private boolean activo = true;

    @OneToOne(targetEntity = RolEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="fk_id_rol")
    @JsonManagedReference
    private RolEntity rol;

    @OneToOne(targetEntity = LocalidadEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="fk_id_localidad")
    @JsonManagedReference
    private  LocalidadEntity localidad;

    @OneToOne(targetEntity = ProvinciaEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="fk_id_provincia")
    @JsonManagedReference
    private  ProvinciaEntity provincia;

    @OneToOne(targetEntity = PaisEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="fk_id_pais")
    @JsonManagedReference
    private PaisEntity pais;

    @OneToMany(mappedBy = "solicitante", targetEntity = LicenciaEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<LicenciaEntity> licencias;

}
