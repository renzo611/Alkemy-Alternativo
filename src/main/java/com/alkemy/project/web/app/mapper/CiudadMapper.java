package com.alkemy.project.web.app.mapper;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alkemy.project.web.app.dto.CiudadDto;
import com.alkemy.project.web.app.entity.CiudadEntity;
import com.alkemy.project.web.app.serviceImpl.ContinenteServiceImpl;

@Component
public class CiudadMapper {
	
	@Autowired
	private ContinenteServiceImpl continenteService;
	
	public List<CiudadDto> ciudadEntity2DtoList(List<CiudadEntity> ciudades){
		List<CiudadDto> ciudadesDto = new ArrayList<>();
		for (CiudadEntity ciudad : ciudades) {
			ciudadesDto.add(this.ciudadEntity2Dto(ciudad));
		}
		return ciudadesDto;
	}
	
	public CiudadDto ciudadEntity2Dto(CiudadEntity ciudad) {
		CiudadDto city = new CiudadDto();
		city.setCantHab(ciudad.getCantidadHabitantes());
		city.setContinente(continenteService.getById(ciudad.getId()).getDenominacion());
		city.setDenominacion(ciudad.getDenominacion());
		city.setContinenteid(ciudad.getContinenteid());
		city.setIconosAsociados(ciudad.getIconosAsociados());
		city.setImagen(ciudad.getImagen());
		city.setId(ciudad.getId());
		return city;
	}
	public CiudadEntity CiudadDto2EntityUpdate(CiudadDto newciudad, CiudadEntity ciudad) {
		ciudad.setCantidadHabitantes(newciudad.getCantHab());
		ciudad.setDenominacion(newciudad.getDenominacion());
		ciudad.setImagen(newciudad.getImagen());
		ciudad.setContinenteid(newciudad.getContinenteid());
		ciudad.setIconosAsociados(newciudad.getIconosAsociados());
		return ciudad;
	}
}
