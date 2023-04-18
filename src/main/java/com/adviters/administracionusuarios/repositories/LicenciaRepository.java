package com.adviters.administracionusuarios.repositories;

import com.adviters.administracionusuarios.models.entities.LicenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LicenciaRepository  extends JpaRepository<LicenciaEntity, Long> {

    @Override
    @Query("SELECT l FROM LicenciaEntity l WHERE l.activo = true")
    List<LicenciaEntity> findAll();
}
