package com.adviters.administracionusuarios.utils.mappers;

import com.adviters.administracionusuarios.models.dtos.UserDto;

import com.adviters.administracionusuarios.models.dtos.UserLoggedDto;
import com.adviters.administracionusuarios.models.entities.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public UserDto entityToDTO(UserEntity entity) {
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setApellido(entity.getApellido());
        dto.setPassword(entity.getPassword());
        dto.setRol(entity.getRol().getNombre());
        dto.setId_supervisor(entity.getId_supervisor());
        dto.setDias_de_vacaciones(entity.getDias_de_vacaciones());
        return dto;
    }

    public UserLoggedDto entityToLoggedDto(UserEntity entity) {
        UserLoggedDto dto = new UserLoggedDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getUsername());
        dto.setRol(entity.getRol().getNombre());
        dto.setFoto(entity.getFoto());
        return dto;
    }

    public UserEntity dtoToEntity(UserDto dto) {
        UserEntity entity = new UserEntity();
        entity.setUsername(dto.getUsername());
        entity.setApellido(dto.getApellido());
        entity.setPassword(dto.getPassword());
        entity.setId_supervisor(dto.getId_supervisor());
        entity.setDias_de_vacaciones(dto.getDias_de_vacaciones());
        return entity;
    }

    public List<UserDto> entityListToDtosList(List<UserEntity> entities) {
        List<UserDto> dtos = new ArrayList<>();
        for (UserEntity entity : entities) {
            UserDto dto = entityToDTO(entity);
            dtos.add(dto);
        }
        return dtos;
    }
}
