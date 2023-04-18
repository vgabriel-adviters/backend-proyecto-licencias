package com.adviters.administracionusuarios.repositories;

import com.adviters.administracionusuarios.models.entities.LicenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LicenciaRepository  extends JpaRepository<LicenciaEntity, Long> {

    @Override
    @Query("SELECT l FROM LicenciaEntity WHERE l.activo = true")
    List<LicenciaEntity> findAll();
}
