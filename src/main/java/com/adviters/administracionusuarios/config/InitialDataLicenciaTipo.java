package com.adviters.administracionusuarios.config;

import com.adviters.administracionusuarios.models.entities.LicenciaEstadoEntity;
import com.adviters.administracionusuarios.models.entities.LicenciaTipoEntity;
import com.adviters.administracionusuarios.repositories.LicenciaEstadoRepository;
import com.adviters.administracionusuarios.repositories.LicenciaTipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class InitialDataLicenciaTipo {

    @Autowired
    private LicenciaTipoRepository tipoRepository;

    @PostConstruct
    public void loadInitialData() {
        if (tipoRepository.count() == 0) {
            LicenciaTipoEntity tipo1 = new LicenciaTipoEntity();
            tipo1.setId(1L);
            tipo1.setNombre("tramites");

            LicenciaTipoEntity tipo2 = new LicenciaTipoEntity();
            tipo2.setId(2L);
            tipo2.setNombre("dias de estudio");

            LicenciaTipoEntity tipo3 = new LicenciaTipoEntity();
            tipo3.setId(3L);
            tipo3.setNombre("vacaciones");

            tipoRepository.saveAll(Arrays.asList(tipo1, tipo2, tipo3));
        }
    }
}
