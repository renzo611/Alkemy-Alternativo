package com.alkemy.project.web.app.entity;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "icono")
public class IconoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column
	private Long id;
	
	@Column
	private String imagen;
	
	@Column
	private String denominacion;
	

	private Date fechaCreacion;
	
	@Column
	private float altura;
	
	@Column
	private String historia;
	
	@Column(name = "ciudad_id", nullable = false)
	private Long idCiudad;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="ciudad_id", insertable = false, updatable = false)
	private CiudadEntity ciudad;
	
	@ManyToMany(mappedBy = "iconosAsociados")
	private List<CiudadEntity> ciudades = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public String getDenominacion() {
		return denominacion;
	}


	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}


	public Date getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public float getAltura() {
		return altura;
	}


	public void setAltura(float altura) {
		this.altura = altura;
	}


	public String getHistoria() {
		return historia;
	}


	public void setHistoria(String historia) {
		this.historia = historia;
	}


	public Long getIdCiudad() {
		return idCiudad;
	}


	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}


	public List<CiudadEntity> getCiudades() {
		return ciudades;
	}


	public void setCiudades(List<CiudadEntity> ciudades) {
		this.ciudades = ciudades;
	}
	
	
	
}
