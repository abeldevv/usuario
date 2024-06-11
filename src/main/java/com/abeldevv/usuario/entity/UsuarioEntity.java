package com.abeldevv.usuario.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="usuarios")
public class UsuarioEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdUsuario;
	@Column(name="nombre_usuario")
	private String nombre;
	@Column(name="apellidos_usuario")
	private String apellidosUsuario;
	@Column(name="edad")
	private Integer edadUsuario;
	@Column(name="password")
	private String password;
	@Column(name="email")	
	private String email;
	@Column(name="direccion")
	private String direccion;
	@Column(name="pais")
	private String pais;


}
