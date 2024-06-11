package com.abeldevv.usuario.audit;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="auditoria")
public class AuditoriaEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_auditoria;
	@Column(name="id_usuario")
	private String idUsuario;
	@Column(name="fecha_hora")
	private Date fechaHora;
	@Column(name="accion")
	private String accion;
	@Column(name="detales")
	private String detalles;

}
