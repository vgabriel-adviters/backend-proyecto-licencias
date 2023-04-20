package com.adviters.administracionusuarios.controllers;

import com.adviters.administracionusuarios.models.dtos.ErrorDto;
import com.adviters.administracionusuarios.models.dtos.licencias.LicenciaFullDto;
import com.adviters.administracionusuarios.models.dtos.licencias.LicenciaMinimaDto;
import com.adviters.administracionusuarios.models.dtos.licencias.LicenciaNuevaDto;
import com.adviters.administracionusuarios.models.entities.LicenciaEntity;
import com.adviters.administracionusuarios.services.LicenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/licencias")
@CrossOrigin
public class LicenciaController {

    @Autowired
    private LicenciaService licenciaService;

    @PostMapping
    public ResponseEntity<?> crearLicencia(@RequestBody LicenciaNuevaDto dto) {
        Optional<LicenciaEntity> licenciaOptional = licenciaService.guardar(dto);
        if (licenciaOptional.isPresent()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
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

    @GetMapping("/pendientes/{id}")
    public ResponseEntity<?> obtenerLicenciasPendientes(@PathVariable Long id) {
        Optional<List<LicenciaMinimaDto>> optionalPendientes = licenciaService.buscarLicenciasPendientes(id);
        if (optionalPendientes.isPresent()) {
            return ResponseEntity.ok(optionalPendientes.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto("Licencias no encontradas"));
        }
    }

    @GetMapping("/aprobadas/supervisor/{id}")
    public ResponseEntity<?> obtenerLicenciasAprobadasPorSupervisor(@PathVariable Long id) {
        Optional<List<LicenciaMinimaDto>> optionalAprobadas = licenciaService.buscarLicenciasAprobadasPorSupervisor(id);
        if (optionalAprobadas.isPresent()) {
            return ResponseEntity.ok(optionalAprobadas.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto("Licencias no encontradas"));
        }
    }

    @GetMapping("/aprobadas/usuario/{id}")
    public ResponseEntity<?> obtenerLicenciasAprobadasDelUsuario(@PathVariable Long id) {
        Optional<List<LicenciaMinimaDto>> optionalAprobadas = licenciaService.buscarLicenciasAprobadasDelUsuario(id);
        if (optionalAprobadas.isPresent()) {
            return ResponseEntity.ok(optionalAprobadas.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto("Licencias no encontradas"));
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> cambiarEstadoDeLicencia(@RequestParam Long idLicencia, @RequestParam String estado) {
        licenciaService.actualizarLicencia(idLicencia, estado);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/cancelar")
    public ResponseEntity<?> cancelarLicencia(@RequestParam Long idLicencia) {
        licenciaService.eliminarLicencia(idLicencia);
        return ResponseEntity.ok().build();
    }

}
