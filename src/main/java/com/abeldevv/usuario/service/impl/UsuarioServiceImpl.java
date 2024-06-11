package com.abeldevv.usuario.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.abeldevv.usuario.dto.UsuarioDto;
import com.abeldevv.usuario.entity.UsuarioEntity;
import com.abeldevv.usuario.repository.UsuarioRepository;
import com.abeldevv.usuario.respuesta.UsuarioRespuesta;
import com.abeldevv.usuario.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);

	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	@Override
	public ResponseEntity<UsuarioDto>guardarUsuarios(UsuarioDto usuarioDto) {
		
		System.out.println("Este es el mail---->>>: "+usuarioDto.getEmail());
		
		 UsuarioEntity usuario = new UsuarioEntity();
	        usuario.setNombre(usuarioDto.getNombre());
	        usuario.setApellidosUsuario(usuarioDto.getApellidos());
	        usuario.setEdadUsuario(usuarioDto.getEdad());
	        usuario.setEmail(usuarioDto.getEmail());
	        usuario.setPassword(usuarioDto.getPassword());
	        usuario.setDireccion(usuarioDto.getDireccion());
	        usuario.setPais(usuarioDto.getPais());
	        usuario = usuarioRepository.save(usuario);
	        return ResponseEntity.ok(usuarioDto);
	}

	@Override
    public ResponseEntity<UsuarioRespuesta> obtenerUsuarioPorId(Integer idUsuario) {
        UsuarioEntity usuario = usuarioRepository.findById(idUsuario).orElse(null);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        UsuarioRespuesta usuarioRespuesta = new UsuarioRespuesta();
        usuarioRespuesta.setIdUsuario(usuario.getIdUsuario());
        usuarioRespuesta.setNombre(usuario.getNombre());
        usuarioRespuesta.setEmail(usuario.getEmail());
        usuarioRespuesta.setPassword(usuario.getPassword());

        return ResponseEntity.ok(usuarioRespuesta);
    }

	 @Override
	    public ResponseEntity<List<UsuarioRespuesta>> obtenerTodosLosUsuarios() {
	        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
	        List<UsuarioRespuesta> usuariosDto = usuarios.stream().map(usuario -> {
	        	UsuarioRespuesta dto = new UsuarioRespuesta();
	            dto.setIdUsuario(usuario.getIdUsuario());
	            dto.setNombre(usuario.getNombre());
	            dto.setEmail(usuario.getEmail());
	            dto.setPassword(usuario.getPassword());
	            return dto;
	        }).collect(Collectors.toList());

	        return ResponseEntity.ok(usuariosDto);
	    }

	 @Override
	    public ResponseEntity<Void> eliminarUsuario(Integer idUsuario) {
	        if (usuarioRepository.existsById(idUsuario)) {
	            usuarioRepository.deleteById(idUsuario);
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

//	 @Override
//	 public ResponseEntity<UsuarioDto> actualizarUsuario(UsuarioDto dto, Integer idUsuario) {
//	     try {
//	         Optional<UsuarioEntity> optionalUsuario = usuarioRepository.findById(idUsuario);
//	         if (optionalUsuario.isPresent()) {
//	             UsuarioEntity usuario = optionalUsuario.get();
//	             logger.info("Iniciando la actualizacion del usuario");
//	             usuario.setNombre(dto.getNombre());
//	             usuario.setApellidosUsuario(dto.getApellidos());
//	             usuario.setEdadUsuario(dto.getEdad());
//	             usuario.setEmail(dto.getEmail());
//	             usuario.setPassword(dto.getPassword());
//	             usuario.setDireccion(dto.getDireccion());
//	             usuario.setPais(dto.getPais());
//	             logger.info("Antes del guardaddo");
//	             usuario = usuarioRepository.save(usuario);
//
//	             logger.info("Usuario guardado con éxito: {}", usuario);
//
//	             // Construye el DTO de respuesta
//	             UsuarioDto usuarioDtoActualizado = new UsuarioDto();
//	             usuarioDtoActualizado.setNombre(usuario.getNombre());
//	             usuarioDtoActualizado.setApellidos(usuario.getApellidosUsuario());
//	             usuarioDtoActualizado.setEdad(usuario.getEdadUsuario());
//	             usuarioDtoActualizado.setEmail(usuario.getEmail());
//	             usuarioDtoActualizado.setPassword(usuario.getPassword());
//	             usuarioDtoActualizado.setDireccion(usuario.getDireccion());
//	             usuarioDtoActualizado.setPais(usuario.getPais());
//
//	             return ResponseEntity.ok(usuarioDtoActualizado);
//	         }
//	     } catch (Exception e) {
//	         logger.error("Usuario no encontrado");
//	     }
//	     return ResponseEntity.notFound().build();
//	 }


}
