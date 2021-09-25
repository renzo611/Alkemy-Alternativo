package com.alkemy.project.web.app.entity;

import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "icono")
public class IconoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column
	private Long id;
	
	@NotEmpty
	@NotBlank
	@Column
	private String imagen;
	
	@NotEmpty
	@NotBlank
	@Column
	private String denominacion;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@NotNull
	@Column
	private LocalTime fechaCreacion;
	
	@NotNull
	@Column
	private float altura;
	
	@NotEmpty
	@NotBlank
	@Column
	private String historia;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "pais_id")
	private CiudadEntity ciudad;
}
