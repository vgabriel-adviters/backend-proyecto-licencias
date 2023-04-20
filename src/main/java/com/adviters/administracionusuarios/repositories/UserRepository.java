package com.adviters.administracionusuarios.repositories;

import com.adviters.administracionusuarios.models.dtos.UserDto;
import com.adviters.administracionusuarios.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM UserEntity u WHERE u.username = :username AND u.password = :password")
    boolean existeUsuarioPorCredenciales(@Param("username") String username, @Param("password") String password);

    @Override
    @Query("SELECT u FROM UserEntity u WHERE u.activo = true")
    List<UserEntity> findAll();

    @Query("SELECT u FROM UserEntity u WHERE u.id_supervisor = :id AND u.activo = true")
    List<UserEntity> findAllBySupervisor(@Param("id") Long id);

    @Query("SELECT u FROM UserEntity u WHERE u.username = :username AND u.password = :clave")
    Optional<UserEntity> obtenerUsuarioPorNombreYClave(@Param("username") String username, @Param("clave") String clave);

    @Override
    @Modifying
    @Query("UPDATE UserEntity u SET u.activo = false WHERE u.id = :idUsuario")
    void deleteById(@Param("idUsuario") Long idUsuario);
}
