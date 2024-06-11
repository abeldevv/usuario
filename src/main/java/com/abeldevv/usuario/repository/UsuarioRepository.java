package com.abeldevv.usuario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abeldevv.usuario.entity.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
	
//	Optional<UsuarioEntity> save(Optional<UsuarioEntity> usuario);

}
