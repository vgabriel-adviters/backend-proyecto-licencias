package com.adviters.administracionusuarios.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adviters.administracionusuarios.models.entities.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<RolEntity, Long> {
}
