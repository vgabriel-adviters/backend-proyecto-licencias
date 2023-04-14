package com.adviters.administracionusuarios.services;

import com.adviters.administracionusuarios.models.dtos.UserDto;
import com.adviters.administracionusuarios.models.entities.UserEntity;
import com.adviters.administracionusuarios.repositories.UserRepository;
import com.adviters.administracionusuarios.utils.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserDto getUserById(Long id) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        UserEntity userEntity = userEntityOptional.get();
        return userMapper.entityToDTO(userEntity);

    }

    public boolean exists(String username, String password) {
        return userRepository.existeUsuarioPorCredenciales(username, password);
    }
}
