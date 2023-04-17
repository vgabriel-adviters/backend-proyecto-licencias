package com.adviters.administracionusuarios.utils.mappers;

import com.adviters.administracionusuarios.models.dtos.LicenciaFullDto;
import com.adviters.administracionusuarios.models.entities.LicenciaEntity;
import org.springframework.stereotype.Component;

@Component
public class LicenciaMapper {

    public LicenciaFullDto entityToPartialFullDto(LicenciaEntity entity) {
        LicenciaFullDto dto = new LicenciaFullDto();
        dto.setId(entity.getId());
        dto.setAdjunto(entity.getAdjunto());
        dto.setFechaPeticion(entity.getFechaPeticion());
        dto.setFechaComienzo(entity.getFechaComienzo());
        dto.setFechaFinalizacion(entity.getFechaFinalizacion());
        dto.setDescripcion(entity.getDescripcion());

        dto.setTipo(entity.getTipo().getNombre());
        dto.setEstado(entity.getEstado().getNombre());
        //dto.setSolicitante(entity.getSolicitante());
        return dto;
    }
}
