package com.adviters.administracionusuarios.repositories;

import com.adviters.administracionusuarios.models.entities.LicenciaTipoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LicenciaTipoRepository extends JpaRepository<LicenciaTipoEntity, Long> {

}
