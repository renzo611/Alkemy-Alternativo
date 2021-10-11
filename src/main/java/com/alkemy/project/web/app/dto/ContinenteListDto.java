package com.alkemy.project.web.app.dto;

public class ContinenteListDto {
	private String imagen;
	private String denominacion;
	
	
	public ContinenteListDto(String imagen, String denominacion) {
		super();
		this.imagen = imagen;
		this.denominacion = denominacion;
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
	
	
}
