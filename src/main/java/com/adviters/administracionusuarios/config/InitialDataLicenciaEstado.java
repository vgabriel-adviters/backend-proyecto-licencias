package com.adviters.administracionusuarios.config;

import com.adviters.administracionusuarios.models.entities.LicenciaEstadoEntity;
import com.adviters.administracionusuarios.repositories.LicenciaEstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class InitialDataLicenciaEstado {

    @Autowired
    private LicenciaEstadoRepository estadoRepository;

    @PostConstruct
    public void loadInitialData() {
        if (estadoRepository.count() == 0) {
            LicenciaEstadoEntity estado1 = new LicenciaEstadoEntity();
            estado1.setId(1L);
            estado1.setNombre("aprobada");

            LicenciaEstadoEntity estado2 = new LicenciaEstadoEntity();
            estado2.setId(2L);
            estado2.setNombre("rechazada");

            LicenciaEstadoEntity estado3 = new LicenciaEstadoEntity();
            estado3.setId(3L);
            estado3.setNombre("pendiente");

            estadoRepository.saveAll(Arrays.asList(estado1, estado2, estado3));
        }
    }
}
