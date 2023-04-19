package com.adviters.administracionusuarios.config;

import com.adviters.administracionusuarios.models.entities.RolEntity;
import com.adviters.administracionusuarios.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class InitialDataLoader {
    @Autowired
    private RolRepository roleRepository;

    @PostConstruct
    public void loadInitialData() {
        if (roleRepository.count() == 0) {
            RolEntity rol1 = new RolEntity();
            rol1.setId(1L);
            rol1.setNombre("Usuario");

            RolEntity rol2 = new RolEntity();
            rol2.setId(2L);
            rol2.setNombre("Supervisor");

            roleRepository.saveAll(Arrays.asList(rol1, rol2));
        }
    }
}
