package com.adviters.administracionusuarios.controllers;

import com.adviters.administracionusuarios.models.dtos.UserDto;
import com.adviters.administracionusuarios.models.dtos.UserFullDto;
import com.adviters.administracionusuarios.models.entities.UserEntity;
import com.adviters.administracionusuarios.repositories.UserRepository;
import com.adviters.administracionusuarios.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@RestController
//@CrossOrigin
@RequestMapping("/api/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

/*    @PostMapping()
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public UserDto access(@RequestBody UserDto userDto) {
        boolean existe = userService.exists(userDto.getUsername(), userDto.getPassword());
        if(existe) {
            return (userDto);
        }
        return null;
    }*/

    @PostMapping
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> crearUsuario(@RequestBody UserFullDto dto) {
        userService.guardarUsuario(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/modificar")
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> modificarUsuario(@RequestBody UserFullDto dto) {
        userService.modificarUsuario(dto);
        return ResponseEntity.ok().build();
    }



    @GetMapping()
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public List<UserFullDto> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUsuarioById(@PathVariable Long id) {
        return userService.getUserById(id);

    }

    @GetMapping("/allInfo/{id}")
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public UserFullDto getUsuarioFullInfoById(@PathVariable Long id) {
        return userService.getUserAllInfoById(id);

    }

}
