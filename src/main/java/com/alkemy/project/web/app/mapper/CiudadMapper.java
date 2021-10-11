package com.alkemy.project.web.app.mapper;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alkemy.project.web.app.dto.CiudadDto;
import com.alkemy.project.web.app.dto.IconoDto;
import com.alkemy.project.web.app.entity.CiudadEntity;
import com.alkemy.project.web.app.entity.IconoEntity;
import com.alkemy.project.web.app.serviceImpl.ContinenteServiceImpl;

@Component
public class CiudadMapper {
	
	@Autowired
	private ContinenteServiceImpl continenteService;
	
	@Autowired
	private IconoMapper iconoMapper;
	
	public List<CiudadDto> ciudadEntity2DtoList(List<CiudadEntity> ciudades){
		List<CiudadDto> ciudadesDto = new ArrayList<>();
		for (CiudadEntity ciudad : ciudades) {
			ciudadesDto.add(this.ciudadEntity2Dto(ciudad));
		}
		return ciudadesDto;
	}
	
	public CiudadDto ciudadEntity2Dto(CiudadEntity ciudad) {
		CiudadDto city = new CiudadDto();
		List<IconoDto> iconosDto = new ArrayList<>();
		city.setCantHab(ciudad.getCantidadHabitantes());
		city.setContinente(continenteService.getById(ciudad.getId()).getDenominacion());
		city.setDenominacion(ciudad.getDenominacion());
		city.setContinenteid(ciudad.getContinenteid());
		city.setImagen(ciudad.getImagen());
		city.setId(ciudad.getId());
		for (IconoEntity icono : ciudad.getIconosAsociados()) {
			iconosDto.add(iconoMapper.iconoEntity2Dto(icono));
		}
		city.setIconosAsociados(iconosDto);
		return city;
	}
	public CiudadEntity CiudadDto2EntityUpdate(CiudadDto newciudad, CiudadEntity ciudad) {
		List<IconoEntity> iconosDto = new ArrayList<>();
		ciudad.setCantidadHabitantes(newciudad.getCantHab());
		ciudad.setDenominacion(newciudad.getDenominacion());
		ciudad.setImagen(newciudad.getImagen());
		ciudad.setContinenteid(newciudad.getContinenteid());
		for (IconoDto icono : newciudad.getIconosAsociados()) {
			iconosDto.add(iconoMapper.iconoDto2Entity(icono));
		}
		ciudad.setIconosAsociados(iconosDto);
		return ciudad;
	}
	
	public CiudadEntity ciudadDto2Entity(CiudadDto ciudad) {
		CiudadEntity city = new CiudadEntity();
		List<IconoEntity> iconosDto = new ArrayList<>();
		city.setCantidadHabitantes(ciudad.getCantHab());
		city.setDenominacion(ciudad.getDenominacion());
		city.setContinenteid(ciudad.getContinenteid());
		city.setImagen(ciudad.getImagen());
		for (IconoDto icono : ciudad.getIconosAsociados()) {
			iconosDto.add(iconoMapper.iconoDto2Entity(icono));
		}
		city.setIconosAsociados(iconosDto);
		return city;
	}
}
