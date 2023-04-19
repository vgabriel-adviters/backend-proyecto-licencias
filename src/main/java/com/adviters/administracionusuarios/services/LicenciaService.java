package com.adviters.administracionusuarios.services;

import com.adviters.administracionusuarios.models.dtos.licencias.LicenciaFullDto;
import com.adviters.administracionusuarios.models.dtos.licencias.LicenciaMinimaDto;
import com.adviters.administracionusuarios.models.dtos.licencias.LicenciaNuevaDto;
import com.adviters.administracionusuarios.models.entities.LicenciaEntity;
import com.adviters.administracionusuarios.models.entities.LicenciaEstadoEntity;
import com.adviters.administracionusuarios.models.entities.LicenciaTipoEntity;
import com.adviters.administracionusuarios.models.entities.UserEntity;
import com.adviters.administracionusuarios.repositories.LicenciaEstadoRepository;
import com.adviters.administracionusuarios.repositories.LicenciaRepository;
import com.adviters.administracionusuarios.repositories.LicenciaTipoRepository;
import com.adviters.administracionusuarios.repositories.UserRepository;
import com.adviters.administracionusuarios.utils.mappers.LicenciaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LicenciaService {

    @Autowired
    private LicenciaMapper licenciaMapper;

    @Autowired
    private LicenciaRepository licenciaRepository;

    @Autowired
    private LicenciaTipoRepository tipoRepository;

    @Autowired
    private LicenciaEstadoRepository estadoRepository;

    @Autowired
    private UserRepository userRepository;


    public void guardar(LicenciaNuevaDto dto) {

        LicenciaEntity entity = licenciaMapper.dtoToNuevaEntity(dto);
        entity.setFechaPeticion(LocalDate.now().toString());

        LicenciaTipoEntity tipoEntity = new LicenciaTipoEntity();
        tipoEntity.setNombre(dto.getTipo());
        Example<LicenciaTipoEntity> tipoExample = Example.of(tipoEntity);
        entity.setTipo(tipoRepository.findOne(tipoExample).get());

        LicenciaEstadoEntity estadoEntity = new LicenciaEstadoEntity();
        estadoEntity.setNombre("pendiente");
        Example<LicenciaEstadoEntity> estadoExample = Example.of(estadoEntity);
        entity.setEstado(estadoRepository.findOne(estadoExample).get());

        entity.setSolicitante(userRepository.findById(dto.getSolicitanteId()).get());
        entity.setSupervisor(userRepository.findById(dto.getSupervisorId()).get());

        licenciaRepository.save(entity);
    }

    public Optional<List<LicenciaMinimaDto>> buscarLicenciasMinimas() {
        List<LicenciaEntity> entities = licenciaRepository.findAll();
        List<LicenciaMinimaDto> dtos = licenciaMapper.entitiesToMinimalsDtos(entities);
        return Optional.ofNullable(dtos);
    }

    public Optional<LicenciaFullDto> buscarFullPorId(Long id) {
        Optional<LicenciaEntity> optionalEntity = licenciaRepository.findById(id);
        LicenciaFullDto dto = licenciaMapper.entityToFullDto(optionalEntity.get());
        return Optional.ofNullable(dto);
    }

    public Optional<List<LicenciaFullDto>> buscarTodasLasLicencias() {
        List<LicenciaEntity> entities = licenciaRepository.findAll();
        List<LicenciaFullDto> dtos = licenciaMapper.entitiesToDtos(entities);
        return Optional.ofNullable(dtos);
    }
    
}
