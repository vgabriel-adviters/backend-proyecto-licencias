package com.adviters.administracionusuarios.utils.mappers;

import com.adviters.administracionusuarios.models.dtos.UserDto;
import com.adviters.administracionusuarios.models.dtos.UserFullDto;
import com.adviters.administracionusuarios.models.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserFullMapper {
    public static UserFullDto entityToDTO(UserEntity entity) {
        UserFullDto dto = new UserFullDto();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setRol(entity.getRol().getNombre());
        dto.setId_supervisor(entity.getId_supervisor());
        dto.setDias_de_vacaciones(entity.getDias_de_vacaciones());
        dto.setFecha_de_nacimiento(entity.getFecha_de_nacimiento());
        dto.setFecha_de_ingreso(entity.getFecha_de_ingreso());
        dto.setDni(entity.getDni());
        dto.setCuil(entity.getCuil());
        dto.setFoto(entity.getFoto());
        dto.setCalle(entity.getCalle());
        dto.setAltura(entity.getAltura());
        dto.setTorre(entity.getTorre());
        dto.setPiso(entity.getPiso());
        dto.setDepartamento(entity.getDepartamento());
        dto.setLocalidad(entity.getLocalidad().getNombre());
        dto.setProvincia(entity.getProvincia().getNombre());
        dto.setPais(entity.getPais().getNombre());

        return dto;
    }

    public static UserEntity dtoToEntity(UserFullDto dto) {
        UserEntity entity = new UserEntity();
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setId_supervisor(dto.getId_supervisor());
        entity.setDias_de_vacaciones(dto.getDias_de_vacaciones());
        entity.setFecha_de_nacimiento(dto.getFecha_de_nacimiento());
        entity.setFecha_de_ingreso(dto.getFecha_de_ingreso());
        entity.setDni(dto.getDni());
        entity.setCuil(dto.getCuil());
        entity.setFoto(dto.getFoto());
        entity.setCalle(dto.getCalle());
        entity.setAltura(dto.getAltura());
        entity.setTorre(dto.getTorre());
        entity.setPiso(dto.getPiso());
        entity.setDepartamento(dto.getDepartamento());

        return entity;
    }
}
