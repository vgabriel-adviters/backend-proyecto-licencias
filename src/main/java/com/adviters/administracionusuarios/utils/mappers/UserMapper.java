package com.adviters.administracionusuarios.utils.mappers;

import com.adviters.administracionusuarios.models.dtos.UserDto;

import com.adviters.administracionusuarios.models.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static UserDto entityToDTO(UserEntity entity) {
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setApellido(entity.getApellido());
        dto.setPassword(entity.getPassword());
        dto.setRol(entity.getRol().getNombre());
        dto.setId_supervisor(entity.getId_supervisor());
        dto.setFoto(entity.getFoto());
        dto.setDias_de_vacaciones(entity.getDias_de_vacaciones());
        return dto;
    }

    public static UserEntity dtoToEntity(UserDto dto) {
        UserEntity entity = new UserEntity();
        entity.setUsername(dto.getUsername());
        entity.setApellido(dto.getApellido());
        entity.setPassword(dto.getPassword());
        entity.setId_supervisor(dto.getId_supervisor());
        entity.setFoto(dto.getFoto());
        entity.setDias_de_vacaciones(dto.getDias_de_vacaciones());
        return entity;
    }

}
