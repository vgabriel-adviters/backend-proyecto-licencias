package com.adviters.administracionusuarios.utils.mappers;

import com.adviters.administracionusuarios.models.dtos.licencias.LicenciaFullDto;
import com.adviters.administracionusuarios.models.dtos.licencias.LicenciaMinimaDto;
import com.adviters.administracionusuarios.models.dtos.licencias.LicenciaNuevaDto;
import com.adviters.administracionusuarios.models.entities.LicenciaEntity;
import com.adviters.administracionusuarios.utils.mappers.Converter;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class LicenciaMapper {

    public LicenciaMinimaDto entityToMinimalDto(LicenciaEntity entity) {
        LicenciaMinimaDto dto = new LicenciaMinimaDto();
        dto.setId(entity.getId());

        dto.setFechaComienzo(Converter.dateToString(entity.getFechaComienzo()));
        dto.setFechaFinalizacion(Converter.dateToString(entity.getFechaFinalizacion()));

        dto.setTipo(entity.getTipo().getNombre());
        dto.setEstado(entity.getEstado().getNombre());
        //dto.setSolicitante(entity.getSolicitante());
        return dto;
    }

    public LicenciaFullDto entityToFullDto(LicenciaEntity entity) {
        LicenciaFullDto dto = new LicenciaFullDto();
        dto.setId(entity.getId());
        dto.setAdjunto(entity.getAdjunto());

        dto.setFechaPeticion(Converter.dateToString(entity.getFechaPeticion()));
        dto.setFechaComienzo(Converter.dateToString(entity.getFechaComienzo()));
        dto.setFechaFinalizacion(Converter.dateToString(entity.getFechaFinalizacion()));

        dto.setDescripcion(entity.getDescripcion());
        dto.setTipo(entity.getTipo().getNombre());
        dto.setEstado(entity.getEstado().getNombre());
        //dto.setSolicitante(entity.getSolicitante());
        return dto;
    }

    public LicenciaEntity nuevoDtoToNuevaEntity(LicenciaNuevaDto dto) {
        LicenciaEntity entity = new LicenciaEntity();
        // TODO: Guardar id del solicitante
        entity.setAdjunto(dto.getAdjunto());

        entity.setFechaPeticion(Converter.stringToDate(dto.getFechaPeticion()));
        entity.setFechaComienzo(Converter.stringToDate(dto.getFechaComienzo()));
        entity.setFechaFinalizacion(Converter.stringToDate(dto.getFechaFinalizacion()));

        entity.setDescripcion(dto.getDescripcion());
        // El tipo y estado se terminar de insertar en el servicio
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
