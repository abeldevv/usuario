package com.abeldevv.usuario.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abeldevv.usuario.dto.UsuarioDto;
import com.abeldevv.usuario.respuesta.UsuarioRespuesta;
import com.abeldevv.usuario.service.UsuarioService;



@RequestMapping("/usuario")
@RestController
public class UsuarioController {
	


	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioService usuarioService;

 

    @PostMapping("/guardar-usuario")
    public ResponseEntity<UsuarioDto> guardarUsuario( @RequestBody UsuarioDto usuarioDto) {
    	
        return usuarioService.guardarUsuarios(usuarioDto);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<UsuarioRespuesta> usuarioPorId(@PathVariable Integer id) {
        return usuarioService.obtenerUsuarioPorId(id);
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioRespuesta>> todosLosUsuarios() {
        return usuarioService.obtenerTodosLosUsuarios();
    }
    
//    @PutMapping("/usuario/{id}")
//    public ResponseEntity<UsuarioDto> actualizarUsuario(@RequestBody UsuarioDto usuarioDto,@PathVariable Integer id) {
//        return usuarioService.actualizarUsuario(usuarioDto,id);
//    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Integer id) {
        return usuarioService.eliminarUsuario(id);
    }
}
