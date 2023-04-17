package com.adviters.administracionusuarios.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class InitialDataLoader {
/*    @Autowired
    private RoleRepository roleRepository;

    @PostConstruct
    public void loadInitialData() {
        if (roleRepository.count() == 0) {
            RoleEntity role1 = new RoleEntity();
            role1.setId(1L);
            role1.setName("empleado");

            RoleEntity role2 = new RoleEntity();
            role2.setId(2L);
            role2.setName("supervisor");

            roleRepository.saveAll(Arrays.asList(role1, role2));
        }
    }*/
}
