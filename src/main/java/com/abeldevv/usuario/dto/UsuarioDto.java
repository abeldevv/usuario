package com.abeldevv.usuario.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioDto {
	
	private String nombre;
	private String apellidos;
	private Integer edad;
	private String password;
	private String email;
	private String direccion;
	private String pais;

}
