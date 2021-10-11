package com.alkemy.project.web.app.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alkemy.project.web.app.dto.ContinenteDto;
import com.alkemy.project.web.app.dto.ContinenteListDto;
import com.alkemy.project.web.app.entity.ContinenteEntity;

@Component
public class ContinenteMapper {
	public ContinenteEntity continenteDto2Entity(ContinenteDto continente) {
		ContinenteEntity cont = new ContinenteEntity();
		cont.setImagen(continente.getImagen());
		cont.setDenominacion(continente.getDenominacion());
		//cont.setCiudades(continente.getCiudades());
		return cont;
	}
	
	public List<ContinenteListDto> continenteEntity2DtoList(List<ContinenteEntity> continentes){
		List<ContinenteListDto> continentesDto = new ArrayList<>();
		for (ContinenteEntity continente : continentes) {
			continentesDto.add(new ContinenteListDto(continente.getImagen(), continente.getDenominacion()));
		}
		return continentesDto;
	}

	public ContinenteDto continenteEntity2Dto(ContinenteEntity continente) {
		ContinenteDto cont = new ContinenteDto();
		cont.setImagen(continente.getImagen());
		cont.setDenominacion(continente.getDenominacion());
		return cont;
	}
}
