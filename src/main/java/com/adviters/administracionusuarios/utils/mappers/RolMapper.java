package com.adviters.administracionusuarios.utils.mappers;

import com.adviters.administracionusuarios.models.dtos.RolDto;
import com.adviters.administracionusuarios.models.dtos.UserDto;
import com.adviters.administracionusuarios.models.entities.RolEntity;
import com.adviters.administracionusuarios.models.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class RolMapper {
    public RolDto entityToDTO(RolEntity entity) {
        RolDto dto = new RolDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        return dto;
    }

    public RolEntity dtoToEntity(RolDto dto) {
        RolEntity entity = new RolEntity();
        // entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        return entity;
    }
}
