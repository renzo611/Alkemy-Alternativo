package com.alkemy.project.web.app.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IconoDto {
	private Long id;
	private String imagen;
	private String denominacion;
	private Date fechaCreacion;
	private float altura;
	private String historia;
	private Long idCiudad;
	private List<CiudadDto> paises;
	

	public IconoDto(Long id, String imagen, String denominacion, Date fechaCreacion, float altura, String historia,Long idCiudad) {
		this.id = id;
		this.imagen = imagen;
		this.denominacion = denominacion;
		this.fechaCreacion = fechaCreacion;
		this.altura = altura;
		this.historia = historia;
		this.idCiudad = idCiudad;
		this.paises = new ArrayList<>();
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

	public List<CiudadDto> getPaises() {
		return paises;
	}

	public void setPaises(List<CiudadDto> paises) {
		this.paises = paises;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}
	
	
	

}
