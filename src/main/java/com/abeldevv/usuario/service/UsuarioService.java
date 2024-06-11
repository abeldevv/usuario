package com.abeldevv.usuario.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.abeldevv.usuario.dto.UsuarioDto;
import com.abeldevv.usuario.respuesta.UsuarioRespuesta;


@Service
public interface UsuarioService {
	 	
		ResponseEntity<UsuarioDto> guardarUsuarios(UsuarioDto usuarioDto);
	    ResponseEntity<UsuarioRespuesta> obtenerUsuarioPorId(Integer idUsuario);
	    ResponseEntity<List<UsuarioRespuesta>> obtenerTodosLosUsuarios();
//	    ResponseEntity<UsuarioDto>actualizarUsuario(UsuarioDto dto,Integer idUsuario);
	    ResponseEntity<Void> eliminarUsuario(Integer idUsuario);

}
