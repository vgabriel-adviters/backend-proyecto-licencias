package com.adviters.administracionusuarios.controllers;

import com.adviters.administracionusuarios.models.dtos.ErrorDto;
import com.adviters.administracionusuarios.models.dtos.licencias.LicenciaFullDto;
import com.adviters.administracionusuarios.models.dtos.licencias.LicenciaMinimaDto;
import com.adviters.administracionusuarios.services.LicenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/licencias")
public class LicenciaController {

    @Autowired
    private LicenciaService licenciaService;

    @PostMapping
    public ResponseEntity<?> crearLicencia(@RequestBody LicenciaFullDto dto) {
        licenciaService.guardar(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/minima/{id}")
    public ResponseEntity<?> obtenerLicenciaMinimaPorId(@PathVariable Long id) {
        Optional<List<LicenciaMinimaDto>> optionalDto = licenciaService.buscarLicenciasMinimas();
        if (optionalDto.isPresent()) {
            return ResponseEntity.ok(optionalDto.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto("Licencias no encontradas"));
        }
    }

    @GetMapping("/full/{id}")
    public ResponseEntity<?> obtenerLicenciaCompletaPorId(@PathVariable Long id) {
        Optional<LicenciaFullDto> optionalDto = licenciaService.buscarFullPorId(id);
        if (optionalDto.isPresent()) {
            return ResponseEntity.ok(optionalDto.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto("Licencia no encontrada"));
        }
    }

    @GetMapping
    public List<LicenciaFullDto> obtenerLicencias() {
        return licenciaService.buscarTodasLasLicencias().get();
    }

}
