package com.adviters.administracionusuarios.repositories;

import com.adviters.administracionusuarios.models.entities.FeriadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeriadoRepository extends JpaRepository<FeriadoEntity, Long> {
}
