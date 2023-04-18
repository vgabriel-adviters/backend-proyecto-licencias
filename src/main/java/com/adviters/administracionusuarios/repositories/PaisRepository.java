package com.adviters.administracionusuarios.repositories;

import com.adviters.administracionusuarios.models.entities.PaisEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<PaisEntity, Long> {
}
