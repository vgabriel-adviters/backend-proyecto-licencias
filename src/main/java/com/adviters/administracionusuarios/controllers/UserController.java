package com.adviters.administracionusuarios.controllers;

import com.adviters.administracionusuarios.models.dtos.*;
import com.adviters.administracionusuarios.models.entities.UserEntity;
import com.adviters.administracionusuarios.repositories.UserRepository;
import com.adviters.administracionusuarios.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/acceso")
    public ResponseEntity<?> obtenerAcceso(@RequestBody UserLoginDto dto) {
        Optional<UserLoggedDto> usuarioOptional = userService.buscarUsuarioPorCredenciales(dto);
        if (usuarioOptional.isPresent()) {
            return ResponseEntity.ok().body(usuarioOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> crearUsuario(@RequestBody UserFullDto dto) {
        userService.guardarUsuario(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<UserFullDto> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUsuarioById(@PathVariable Long id) {
        return userService.getUserById(id);

    }

    @GetMapping("/allInfo/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserFullDto getUsuarioFullInfoById(@PathVariable Long id) {
        return userService.getUserAllInfoById(id);
    }

    @GetMapping("/supervisor/{id}")
    public List<UserDto> obtenerUsuariosDeSupervisor(@PathVariable Long id) {
        return userService.buscarUsuarios(id);
    }

    @GetMapping("/supervisores")
    public List<UserMinimoDto> obtenerSupervisores() {
        List<UserMinimoDto> supervisores = userService.buscarSupervisores();
        return supervisores;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> modificarDatosDeUsuario(@PathVariable Long id, @RequestBody UserFullDto fullDto) {
        Optional<UserEntity> usuarioActualizado = userService.actualizar(id, fullDto);
        if (usuarioActualizado.isPresent()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> inhabilitarUsuario(@PathVariable Long id) {
        userService.softDeleteUsuario(id);
        return ResponseEntity.ok().build();
    }
}
