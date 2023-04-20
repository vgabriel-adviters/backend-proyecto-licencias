package com.adviters.administracionusuarios.repositories;

import com.adviters.administracionusuarios.models.entities.LicenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LicenciaRepository  extends JpaRepository<LicenciaEntity, Long> {

    @Override
    @Query("SELECT l FROM LicenciaEntity l WHERE l.activo = true")
    List<LicenciaEntity> findAll();

    @Query("SELECT l FROM LicenciaEntity l JOIN l.estado e JOIN l.supervisor sp WHERE e.nombre = 'pendiente' AND sp.id = :idSupervisor AND l.activo = true")
    List<LicenciaEntity> licenciasPendientes(@Param("idSupervisor") Long idSupervisor);


    @Query("SELECT l FROM LicenciaEntity l JOIN l.estado e JOIN l.supervisor sp WHERE e.nombre = 'aprobada' AND sp.id = :idSupervisor AND l.activo = true")
    List<LicenciaEntity> licenciasAprobadasPorSupervisor(@Param("idSupervisor") Long idSupervisor);

    @Query("SELECT l FROM LicenciaEntity l JOIN l.estado e JOIN l.solicitante s WHERE e.nombre = 'aprobada' AND s.id = :idUsuario AND l.activo = true")
    List<LicenciaEntity> licenciasAprobadasDelUsuario(@Param("idUsuario") Long idUsuario);

    @Override
    @Modifying
    @Query("UPDATE LicenciaEntity l SET l.activo = false WHERE l.id = :idLicencia")
    void deleteById(@Param("idLicencia") Long idLicencia);
}
