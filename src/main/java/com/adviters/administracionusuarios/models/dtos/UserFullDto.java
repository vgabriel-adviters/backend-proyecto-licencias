package com.adviters.administracionusuarios.models.dtos;

import com.adviters.administracionusuarios.models.entities.LocalidadEntity;
import com.adviters.administracionusuarios.models.entities.PaisEntity;
import com.adviters.administracionusuarios.models.entities.ProvinciaEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFullDto {
    private Long id;

    private String username;

    private String password;

    private String rol;

    private Long id_supervisor;

    private String fecha_de_nacimiento;

    private String fecha_de_ingreso;

    private String dni;

    private String cuil;

    private String dias_de_vacaciones;

    private  String foto;

    private  String calle;

    private  Long altura;

    private  String torre;

    private  int piso;

    private  String departamento;

    private  String localidad;

    private  String provincia;

    private  String pais;

}
