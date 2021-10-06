package com.alkemy.project.web.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ciudad")
public class CiudadEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NotBlank
	@NotEmpty
	@Column
	private String imagen;
	
	@NotBlank
	@NotEmpty
	@Column
	private String denominacion;
	
	@NotNull
	@Column
	private Long cantidadHabitantes;
	
	@NotNull
	@Column
	private float superficie;
	
	@Column(name = "continente_id", nullable = false)
	private Long continenteid; 
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="continente_id", insertable = false, updatable = false)
	private ContinenteEntity continente;
	
	@ManyToMany(fetch = FetchType.LAZY,
	cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE
	})
	@JoinTable(
				name = "icono_ciudad",
				joinColumns = @JoinColumn(name = "ciudad_id"),
				inverseJoinColumns  = @JoinColumn(name = "icono_id")
	)
	private List<IconoEntity> iconosAsociados = new ArrayList<>();

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

	public Long getCantidadHabitantes() {
		return cantidadHabitantes;
	}

	public void setCantidadHabitantes(Long cantidadHabitantes) {
		this.cantidadHabitantes = cantidadHabitantes;
	}

	public float getSuperficie() {
		return superficie;
	}

	public void setSuperficie(float superficie) {
		this.superficie = superficie;
	}

	public Long getContinenteid() {
		return continenteid;
	}

	public void setContinenteid(Long continenteid) {
		this.continenteid = continenteid;
	}

	public ContinenteEntity getContinente() {
		return continente;
	}

	public void setIconosAsociados(List<IconoEntity> iconosAsociados) {
		this.iconosAsociados = iconosAsociados;
	}
	public List<IconoEntity> getIconosAsociados() {
		return iconosAsociados;
	}


	public Long getId() {
		return id;
	}

	
}
