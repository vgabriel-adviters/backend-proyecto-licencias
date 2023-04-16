package com.adviters.administracionusuarios.controllers;

import com.adviters.administracionusuarios.models.dtos.UserDto;
import com.adviters.administracionusuarios.models.entities.UserEntity;
import com.adviters.administracionusuarios.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public UserDto access(@RequestBody UserDto userDto) {
        boolean existe = userService.exists(userDto.getUsername(), userDto.getPassword());
        if(existe) {
            return (userDto);
        }
        return null;
    }

    @GetMapping("/{id}")
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserDto> getUsuarioById(@PathVariable Long id) {
        UserDto usuario = userService.getUserById(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
