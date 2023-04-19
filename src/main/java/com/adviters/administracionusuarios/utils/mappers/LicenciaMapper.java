package com.adviters.administracionusuarios.utils.mappers;

import com.adviters.administracionusuarios.models.dtos.licencias.LicenciaFullDto;
import com.adviters.administracionusuarios.models.dtos.licencias.LicenciaMinimaDto;
import com.adviters.administracionusuarios.models.dtos.licencias.LicenciaNuevaDto;
import com.adviters.administracionusuarios.models.entities.LicenciaEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class LicenciaMapper {

    public LicenciaEntity dtoToNuevaEntity(LicenciaNuevaDto dto) {
        LicenciaEntity entity = new LicenciaEntity();
        entity.setAdjunto(dto.getAdjunto());
        entity.setFechaComienzo(dto.getFechaComienzo());
        entity.setFechaFinalizacion(dto.getFechaFinalizacion());
        entity.setDescripcion(dto.getDescripcion());
        return entity;
    }

    public LicenciaMinimaDto entityToMinimalDto(LicenciaEntity entity) {
        LicenciaMinimaDto dto = new LicenciaMinimaDto();
        dto.setId(entity.getId());
        dto.setTipo(entity.getTipo().getNombre());
        dto.setEstado(entity.getEstado().getNombre());
        dto.setFechaComienzo(entity.getFechaComienzo());
        dto.setFechaFinalizacion(entity.getFechaFinalizacion());
        dto.setFotoSolicitante(entity.getSolicitante().getFoto());
        dto.setNombreSolicitante(entity.getSolicitante().getUsername());
        dto.setSolicitanteId(entity.getSolicitante().getId());
        return dto;
    }

    public LicenciaFullDto entityToFullDto(LicenciaEntity entity) {
        LicenciaFullDto dto = new LicenciaFullDto();
        dto.setId(entity.getId());
        dto.setTipo(entity.getTipo().getNombre());
        dto.setEstado(entity.getEstado().getNombre());
        dto.setAdjunto(entity.getAdjunto());
        dto.setFechaPeticion(entity.getFechaPeticion());
        dto.setFechaComienzo(entity.getFechaComienzo());
        dto.setFechaFinalizacion(entity.getFechaFinalizacion());
        dto.setDescripcion(entity.getDescripcion());
        dto.setNombreSolicitante(entity.getSolicitante().getUsername());
        dto.setFotoSolicitante(entity.getSolicitante().getFoto());
        dto.setNombreSupervisor(entity.getSupervisor().getUsername());
        dto.setFotoSupervisor(entity.getSupervisor().getFoto());
        return dto;
    }

    public LicenciaEntity dtoToEntity(LicenciaFullDto dto) {
        LicenciaEntity entity = new LicenciaEntity();
        entity.setId(dto.getId());
        entity.setAdjunto(dto.getAdjunto());
        entity.setFechaPeticion(dto.getFechaPeticion());
        entity.setFechaComienzo(dto.getFechaComienzo());
        entity.setFechaFinalizacion(dto.getFechaFinalizacion());
        entity.setDescripcion(dto.getDescripcion());
        return entity;
    }

    public List<LicenciaFullDto> entitiesToDtos(List<LicenciaEntity> entities) {
        List<LicenciaFullDto> dtos = new ArrayList<>();
        for (LicenciaEntity entity : entities) {
            LicenciaFullDto dto = entityToFullDto(entity);
            dtos.add(dto);
        }
        return dtos;
    }

    public List<LicenciaMinimaDto> entitiesToMinimalsDtos(List<LicenciaEntity> entities) {
        List<LicenciaMinimaDto> dtos = new ArrayList<>();
        for (LicenciaEntity entity : entities) {
            LicenciaMinimaDto dto = entityToMinimalDto(entity);
            dtos.add(dto);
        }
        return dtos;
    }
}
