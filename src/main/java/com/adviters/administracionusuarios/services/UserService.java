package com.adviters.administracionusuarios.services;

import com.adviters.administracionusuarios.models.dtos.UserDto;
import com.adviters.administracionusuarios.models.dtos.UserFullDto;
import com.adviters.administracionusuarios.models.dtos.UserLoggedDto;
import com.adviters.administracionusuarios.models.dtos.UserLoginDto;
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

    public boolean exists(String username, String password) {
        return userRepository.existeUsuarioPorCredenciales(username, password);
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

    public void softDeleteUsuario(Long id) {
        userRepository.deleteById(id);
    }
}
