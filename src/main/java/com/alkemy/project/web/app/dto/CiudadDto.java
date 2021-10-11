package com.alkemy.project.web.app.dto;

import java.util.List;

import com.alkemy.project.web.app.entity.IconoEntity;

public class CiudadDto {
	private Long id;
	private String imagen;
	private String denominacion;
	private Long cantHab;
	private String continente;
	private List<IconoDto> iconosAsociados;
	private Long continenteid;
	
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Long getCantHab() {
		return cantHab;
	}
	public void setCantHab(Long cantHab) {
		this.cantHab = cantHab;
	}
	public String getContinente() {
		return continente;
	}
	
	public void setContinente(String continente) {
		this.continente = continente;
	}
	
	public List<IconoDto> getIconosAsociados() {
		return iconosAsociados;
	}
	public void setIconosAsociados(List<IconoDto> iconosAsociados) {
		this.iconosAsociados = iconosAsociados;
	}
	
	public Long getContinenteid() {
		return this.continenteid;
	}
	
	public void setContinenteid(Long continenteid) {
		this.continenteid = continenteid;
	}
}
