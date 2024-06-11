package com.abeldevv.usuario.respuesta;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioRespuesta {
    private Integer idUsuario;
    private String nombre;
    private String apellidos;
    private Integer edad;
    private String password;
    private String email;
    private String direccion;
    private String pais;
}
