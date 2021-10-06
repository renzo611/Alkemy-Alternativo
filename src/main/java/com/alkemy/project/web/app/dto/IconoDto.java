package com.alkemy.project.web.app.dto;

public class IconoDto {
	private Long id;
	private String imagen;
	private String denominacion;

	
	public IconoDto(String imagen, String denominacion) {
		this.imagen = imagen;
		this.denominacion = denominacion;
	}
	
	public IconoDto(Long id, String imagen, String denominacion) {
		this.id = id;
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

	public Long getId() {
		return id;
	}
	
	

}
