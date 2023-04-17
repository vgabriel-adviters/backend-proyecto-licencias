package com.adviters.administracionusuarios.services;

import com.adviters.administracionusuarios.models.dtos.LicenciaFullDto;
import com.adviters.administracionusuarios.models.entities.LicenciaEntity;
import com.adviters.administracionusuarios.repositories.LicenciaRepository;
import com.adviters.administracionusuarios.utils.mappers.LicenciaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LicenciaService {

    @Autowired
    private LicenciaRepository licenciaRepository;

    @Autowired
    private LicenciaMapper licenciaMapper;

    public Optional<LicenciaFullDto> buscarLicenciaPorId(Long id) {
        Optional<LicenciaEntity> optionalEntity = licenciaRepository.findById(id);
        LicenciaFullDto dto = licenciaMapper.entityToPartialFullDto(optionalEntity.get());
        return Optional.ofNullable(dto);
    }
}
