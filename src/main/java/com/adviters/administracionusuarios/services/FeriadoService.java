package com.adviters.administracionusuarios.services;

import com.adviters.administracionusuarios.models.dtos.FeriadoDto;
import com.adviters.administracionusuarios.models.entities.FeriadoEntity;
import com.adviters.administracionusuarios.repositories.FeriadoRepository;
import com.adviters.administracionusuarios.utils.mappers.FeriadoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeriadoService {

    @Autowired
    private FeriadoRepository feriadoRepository;

    @Autowired
    private FeriadoMapper feriadoMapper;

    public void guardarFeriado(FeriadoDto dto) {
        FeriadoEntity entity = feriadoMapper.dtoToEntity(dto);
        feriadoRepository.save(entity);
    }

    public Optional<List<FeriadoDto>> buscarFeriados() {
        List<FeriadoEntity> entities = feriadoRepository.findAll();
        List<FeriadoDto> dtos = feriadoMapper.entityLisToDtoList(entities);
        return Optional.ofNullable(dtos);
    }
}
