package com.adviters.administracionusuarios.repositories;

import com.adviters.administracionusuarios.models.entities.LocalidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalidadRepository extends JpaRepository<LocalidadEntity, Long> {
}
