package com.adviters.administracionusuarios.services;

import com.adviters.administracionusuarios.models.dtos.UserDto;
import com.adviters.administracionusuarios.models.dtos.UserFullDto;
import com.adviters.administracionusuarios.models.entities.PaisEntity;
import com.adviters.administracionusuarios.models.entities.ProvinciaEntity;
import com.adviters.administracionusuarios.models.entities.RolEntity;
import com.adviters.administracionusuarios.models.entities.UserEntity;
import com.adviters.administracionusuarios.repositories.PaisRepository;
import com.adviters.administracionusuarios.repositories.ProvinciaRepository;
import com.adviters.administracionusuarios.repositories.RolRepository;
import com.adviters.administracionusuarios.repositories.UserRepository;
import com.adviters.administracionusuarios.utils.mappers.UserFullMapper;
import com.adviters.administracionusuarios.utils.mappers.UserMapper;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    public List<UserDto> getUsers() {
        List<UserEntity> userEntityList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for (UserEntity userEntity : userEntityList) {
            userDtoList.add(userMapper.entityToDTO(userEntity));
        }

        return userDtoList;

    }

    public void guardarUsuario(UserFullDto dto) {

        UserEntity entity =userFullMapper.dtoToEntity(dto);
        RolEntity rolEntity = new RolEntity();
        rolEntity.setNombre(dto.getRol());
        Example<RolEntity> rolExample = Example.of(rolEntity);
        if(rolRepository.findOne(rolExample).get() != null)
        entity.setRol(rolRepository.findOne(rolExample).get());

        PaisEntity paisEntity = new PaisEntity();
        paisEntity.setNombre(dto.getPais());
        Example<PaisEntity> paisExample = Example.of(paisEntity);
        if(paisRepository.findOne(paisExample).get() != null){
            entity.setPais(paisRepository.findOne(paisExample).get());
        }
        else{
            entity.setPais(paisEntity);
        }

        ProvinciaEntity provinciaEntity = new ProvinciaEntity();
        provinciaEntity.setNombre(dto.getProvincia());
        Example<ProvinciaEntity> provinciaExample = Example.of(provinciaEntity);
        if(provinciaRepository.findOne(provinciaExample).get() != null)
        entity.setProvincia(provinciaRepository.findOne(provinciaExample).get());
        else{
            entity.setProvincia(provinciaEntity);
        }
        userRepository.save(entity);
    }

    public boolean exists(String username, String password) {
        return userRepository.existeUsuarioPorCredenciales(username, password);
    }



}
