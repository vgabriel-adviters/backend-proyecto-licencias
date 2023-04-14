package com.adviters.administracionusuarios.controllers;

import com.adviters.administracionusuarios.models.dtos.UserDto;
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
    public ResponseEntity<String> access(@RequestBody UserDto userDto) {
        boolean existe = userService.exists(userDto.getUsername(), userDto.getPassword());
        if(existe) {
            return new ResponseEntity<>("Acceso permitido", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("No tiene autorización", HttpStatus.UNAUTHORIZED);
    }

}
