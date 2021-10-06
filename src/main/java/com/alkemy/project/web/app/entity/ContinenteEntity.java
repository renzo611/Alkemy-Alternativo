package com.alkemy.project.web.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "continente")
public class ContinenteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column
	private Long idContinente;
	
	@Column
	private String imagen;
	
	@Column
	private String denominacion;
	
//	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "continente")
//	private List<CiudadEntity> ciudades = new ArrayList<>();

	public Long getIdContinente() {
		return idContinente;
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

//	public List<CiudadEntity> getCiudades() {
//		return ciudades;
//	}
//
//	public void setCiudades(List<CiudadEntity> ciudades) {
//		this.ciudades = ciudades;
//	}	
	
	
}
