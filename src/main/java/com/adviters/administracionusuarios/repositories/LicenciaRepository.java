package com.adviters.administracionusuarios.repositories;

import com.adviters.administracionusuarios.models.entities.LicenciaEntity;
import com.adviters.administracionusuarios.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenciaRepository  extends JpaRepository<LicenciaEntity, Long> {
}
