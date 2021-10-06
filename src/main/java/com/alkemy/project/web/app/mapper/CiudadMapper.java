package com.alkemy.project.web.app.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alkemy.project.web.app.dto.CiudadDto;
import com.alkemy.project.web.app.entity.CiudadEntity;

@Component
public class CiudadMapper {
	public List<CiudadDto> ciudadEntity2DtoList(List<CiudadEntity> ciudades){
		List<CiudadDto> ciudadesDto = new ArrayList<>();
		for (CiudadEntity ciudad : ciudades) {
			ciudadesDto.add(this.ciudadEntity2Dto(ciudad));
		}
		return ciudadesDto;
	}
	
	public CiudadDto ciudadEntity2Dto(CiudadEntity ciudad) {
		CiudadDto city = new CiudadDto(ciudad.getImagen(),ciudad.getDenominacion(),ciudad.getCantidadHabitantes(),ciudad.getContinente().getDenominacion()
				,ciudad.getIconosAsociados(),ciudad.getId());
		return city;
	}
	public CiudadDto ciudadEntity2Dto2(CiudadEntity newciudad) {
		CiudadDto ciudad = new CiudadDto();
		ciudad.setCantHab(newciudad.getCantidadHabitantes());
		ciudad.setDenominacion(newciudad.getDenominacion());
		ciudad.setImagen(newciudad.getImagen());
		ciudad.setIconosAsociados(newciudad.getIconosAsociados());
		ciudad.setContinente(newciudad.getContinente().getDenominacion());
		return ciudad;
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
