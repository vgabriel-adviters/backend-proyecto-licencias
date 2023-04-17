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
        dto.setPassword(entity.getPassword());
        dto.setRol(entity.getRol().getNombre());
        return dto;
    }

    public static UserEntity dtoToEntity(UserDto dto) {
        UserEntity entity = new UserEntity();
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        return entity;
    }

}
