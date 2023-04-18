package com.adviters.administracionusuarios.controllers;

import com.adviters.administracionusuarios.models.dtos.FeriadoDto;
import com.adviters.administracionusuarios.services.FeriadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/feriados")
public class FeriadoController {

    @Autowired
    private FeriadoService feriadoService;

    @PostMapping
    public ResponseEntity<?> crearFeriado(@RequestBody FeriadoDto dto) {
        feriadoService.guardarFeriado(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodosLosFeriados() {
        Optional<List<FeriadoDto>> optionalFeriados = feriadoService.buscarFeriados();
        if (optionalFeriados.isPresent()) {
            return ResponseEntity.ok(optionalFeriados.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
