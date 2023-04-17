package com.adviters.administracionusuarios.repositories;

import com.adviters.administracionusuarios.models.dtos.LicenciaFullDto;
import com.adviters.administracionusuarios.models.entities.LicenciaEntity;
import com.adviters.administracionusuarios.models.entities.UserEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LicenciaRepository  extends JpaRepository<LicenciaEntity, Long> {

}
