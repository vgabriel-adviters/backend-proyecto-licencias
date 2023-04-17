package com.adviters.administracionusuarios.repositories;

import com.adviters.administracionusuarios.models.dtos.UserDto;
import com.adviters.administracionusuarios.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM UserEntity u WHERE u.username = :username AND u.password = :password")
    boolean existeUsuarioPorCredenciales(@Param("username") String username, @Param("password") String password);


//    @Query("SELECT u.username, r.nombre FROM UserEntity u INNER JOIN RolEntity r " +
//            "WHERE u.fk_id_rol = (SELECT u2.fk_id_rol FROM UserEntity u2 " +
//            "WHERE u2.id = :userId) AND r.id = (SELECT u2.fk_id_rol FROM UserEntity u2 WHERE u2.id = :userId)")
//    UserDto findUserById(@Param("userId") Long userId);

    List<UserEntity> findAll();


}
