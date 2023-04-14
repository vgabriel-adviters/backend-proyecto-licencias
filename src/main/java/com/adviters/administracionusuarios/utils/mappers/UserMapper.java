package com.adviters.administracionusuarios.utils.mappers;

import com.adviters.administracionusuarios.models.dtos.UserDto;
import com.adviters.administracionusuarios.models.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto entityToDTO(UserEntity entity) {
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        return dto;
    }

    public UserEntity dtoToEntity(UserDto dto) {
        UserEntity entity = new UserEntity();
        // entity.setId(dto.getId());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        return entity;
    }
}
