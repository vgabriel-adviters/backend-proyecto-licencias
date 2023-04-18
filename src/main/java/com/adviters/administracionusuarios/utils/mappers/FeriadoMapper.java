package com.adviters.administracionusuarios.utils.mappers;

import com.adviters.administracionusuarios.models.dtos.FeriadoDto;
import com.adviters.administracionusuarios.models.entities.FeriadoEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FeriadoMapper {

    public FeriadoDto entityToDto(FeriadoEntity entity) {
        FeriadoDto dto = new FeriadoDto();
        dto.setFecha(entity.getFecha());
        dto.setMotivo(entity.getMotivo());
        return dto;
    }

    public FeriadoEntity dtoToEntity(FeriadoDto dto) {
        FeriadoEntity entity = new FeriadoEntity();
        entity.setFecha(dto.getFecha());
        entity.setMotivo(dto.getMotivo());
        return entity;
    }

    public List<FeriadoDto> entityLisToDtoList(List<FeriadoEntity> entities) {
        List<FeriadoDto> dtos = new ArrayList<>();
        for (FeriadoEntity entity : entities) {
            FeriadoDto dto = entityToDto(entity);
            dtos.add(dto);
        }
        return dtos;
    }
}
