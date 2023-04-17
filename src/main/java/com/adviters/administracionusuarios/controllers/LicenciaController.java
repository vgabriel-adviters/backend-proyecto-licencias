package com.adviters.administracionusuarios.controllers;

import com.adviters.administracionusuarios.models.dtos.LicenciaFullDto;
import com.adviters.administracionusuarios.services.LicenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/licencias")
public class LicenciaController {

    @Autowired
    private LicenciaService licenciaService;

    @GetMapping("{id}")
    public ResponseEntity<LicenciaFullDto> obtenerLicenciaPorId(@PathVariable Long id) {
        Optional<LicenciaFullDto> optionalDto = licenciaService.buscarLicenciaPorId(id);
        if (optionalDto.isPresent()) {
            return ResponseEntity.ok(optionalDto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
