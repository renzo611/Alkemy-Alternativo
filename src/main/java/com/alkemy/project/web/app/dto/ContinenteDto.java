package com.alkemy.project.web.app.dto;

import java.util.ArrayList;
import java.util.List;

import com.alkemy.project.web.app.entity.CiudadEntity;

public class ContinenteDto {
	private String imagen;
	private String denominacion;
	private Long id;
	//private List<CiudadEntity> ciudades = new ArrayList<>(); 
	
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
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
//	public List<CiudadEntity> getCiudades() {
//		return ciudades;
//	}
//	public void setCiudades(List<CiudadEntity> ciudades) {
//		this.ciudades = ciudades;
//	}
	
	
}
