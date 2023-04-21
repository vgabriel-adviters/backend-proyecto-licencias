package com.adviters.administracionusuarios.services;

import com.adviters.administracionusuarios.models.dtos.*;
import com.adviters.administracionusuarios.models.entities.*;
import com.adviters.administracionusuarios.repositories.*;
import com.adviters.administracionusuarios.utils.mappers.UserFullMapper;
import com.adviters.administracionusuarios.utils.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private PaisRepository paisRepository;
    @Autowired
    private ProvinciaRepository provinciaRepository;
    @Autowired
    private LocalidadRepository localidadRepository;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserFullMapper userFullMapper;


    public UserDto getUserById(Long id) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        UserEntity userEntity = userEntityOptional.get();
        return userMapper.entityToDTO(userEntity);

    }

    public UserFullDto getUserAllInfoById(Long id) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        UserEntity userEntity = userEntityOptional.get();
        return userFullMapper.entityToDTO(userEntity);

    }


    public List<UserFullDto> getUsers() {
        List<UserEntity> userEntityList = userRepository.findAll();
        List<UserFullDto> userDtoList = userFullMapper.entityListToDtoList(userEntityList);
        return userDtoList;
    }

    public void guardarUsuario(UserFullDto dto) {

        UserEntity entity = userFullMapper.dtoToEntity(dto);

        RolEntity rolEntity = new RolEntity();
        rolEntity.setNombre(dto.getRol());
        Example<RolEntity> rolExample = Example.of(rolEntity);
        Optional<RolEntity> optionalRol = rolRepository.findOne(rolExample);
        if(optionalRol.isPresent()) {
            entity.setRol(optionalRol.get());
        }

        PaisEntity paisEntity = new PaisEntity();
        paisEntity.setNombre(dto.getPais());
        Example<PaisEntity> paisExample = Example.of(paisEntity);
        Optional<PaisEntity> paisOptional = paisRepository.findOne(paisExample);
        if (paisOptional.isPresent()) {
            entity.setPais(paisOptional.get());
        } else {
            entity.setPais(paisEntity);
        }

        ProvinciaEntity provinciaEntity = new ProvinciaEntity();
        provinciaEntity.setNombre(dto.getProvincia());
        Example<ProvinciaEntity> provinciaExample = Example.of(provinciaEntity);
        Optional<ProvinciaEntity> provinciaOptional = provinciaRepository.findOne(provinciaExample);
        if (provinciaOptional.isPresent()) {
            entity.setProvincia(provinciaOptional.get());
        } else {
            entity.setProvincia(provinciaEntity);
        }

        LocalidadEntity localidadEntity = new LocalidadEntity();
        localidadEntity.setNombre(dto.getLocalidad());
        Example<LocalidadEntity> localidadExample = Example.of(localidadEntity);
        Optional<LocalidadEntity> localidadOptional = localidadRepository.findOne(localidadExample);
        if (localidadOptional.isPresent()) {
            entity.setLocalidad(localidadOptional.get());
        } else {
            entity.setLocalidad(localidadEntity);
        }

        userRepository.save(entity);
    }


    public Optional<UserLoggedDto> buscarUsuarioPorCredenciales(UserLoginDto dto) {

        Optional<UserEntity> userEntityOptional = userRepository.obtenerUsuarioPorNombreYClave(dto.getUsername(), dto.getPassword());
        if (userEntityOptional.isPresent()) {
            UserLoggedDto logged = userMapper.entityToLoggedDto(userEntityOptional.get());
            return Optional.ofNullable(logged);
        } else {
            return Optional.empty();
        }
    }

    public List<UserDto> buscarUsuarios(Long id) {
        List<UserEntity> entities = userRepository.findAllBySupervisor(id);
        List<UserDto> dtos = userMapper.entityListToDtosList(entities);
        return dtos;
    }

    public List<UserMinimoDto> buscarSupervisores() {
        List<UserEntity> entities = userRepository.findAllSupervisores();
        List<UserMinimoDto> dtos = userMapper.entityListToMinimoDtoList(entities);
        return dtos;
    }

    public Optional<UserEntity> actualizar(Long id, UserFullDto dto) {
        UserEntity actualizado = new UserEntity();

        actualizado.setId(id);
        actualizado.setUsername(dto.getUsername());
        actualizado.setApellido(dto.getApellido());
        actualizado.setPassword(dto.getPassword());
        actualizado.setId_supervisor(dto.getId_supervisor());
        actualizado.setFecha_de_nacimiento(dto.getFecha_de_nacimiento());
        actualizado.setFecha_de_ingreso(dto.getFecha_de_ingreso());
        actualizado.setDni(dto.getDni());
        actualizado.setCuil(dto.getCuil());
        actualizado.setDias_de_vacaciones(dto.getDias_de_vacaciones());
        actualizado.setFoto(dto.getFoto());
        actualizado.setEmail(dto.getEmail());
        actualizado.setTelefono(dto.getTelefono());
        actualizado.setCodigo_postal(dto.getCodigo_postal());
        actualizado.setCalle(dto.getCalle());
        actualizado.setAltura(dto.getAltura());
        actualizado.setTorre(dto.getTorre());
        actualizado.setPiso(dto.getPiso());
        actualizado.setDepartamento(dto.getDepartamento());

        RolEntity rolEntity = new RolEntity();
        rolEntity.setNombre(dto.getRol());
        Example<RolEntity> rolExample = Example.of(rolEntity);
        Optional<RolEntity> optionalRol = rolRepository.findOne(rolExample);
        if(optionalRol.isPresent()) {
            actualizado.setRol(optionalRol.get());
        }

        PaisEntity paisEntity = new PaisEntity();
        paisEntity.setNombre(dto.getPais());
        Example<PaisEntity> paisExample = Example.of(paisEntity);
        Optional<PaisEntity> paisOptional = paisRepository.findOne(paisExample);
        if (paisOptional.isPresent()) {
            actualizado.setPais(paisOptional.get());
        } else {
            actualizado.setPais(paisEntity);
        }

        ProvinciaEntity provinciaEntity = new ProvinciaEntity();
        provinciaEntity.setNombre(dto.getProvincia());
        Example<ProvinciaEntity> provinciaExample = Example.of(provinciaEntity);
        Optional<ProvinciaEntity> provinciaOptional = provinciaRepository.findOne(provinciaExample);
        if (provinciaOptional.isPresent()) {
            actualizado.setProvincia(provinciaOptional.get());
        } else {
            actualizado.setProvincia(provinciaEntity);
        }

        LocalidadEntity localidadEntity = new LocalidadEntity();
        localidadEntity.setNombre(dto.getLocalidad());
        Example<LocalidadEntity> localidadExample = Example.of(localidadEntity);
        Optional<LocalidadEntity> localidadOptional = localidadRepository.findOne(localidadExample);
        if (localidadOptional.isPresent()) {
            actualizado.setLocalidad(localidadOptional.get());
        } else {
            actualizado.setLocalidad(localidadEntity);
        }

        return Optional.ofNullable(userRepository.save(actualizado));
    }

    public void softDeleteUsuario(Long id) {
        userRepository.deleteById(id);
    }
}
