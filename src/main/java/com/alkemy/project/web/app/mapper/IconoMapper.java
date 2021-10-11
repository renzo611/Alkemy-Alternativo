package com.alkemy.project.web.app.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alkemy.project.web.app.dto.CiudadDto;
import com.alkemy.project.web.app.dto.IconoDto;
import com.alkemy.project.web.app.dto.IconoListDto;
import com.alkemy.project.web.app.entity.CiudadEntity;
import com.alkemy.project.web.app.entity.IconoEntity;

@Component
public class IconoMapper {
	
	@Autowired
	private CiudadMapper ciudadMapper;
	
	public List<IconoListDto> iconoEntity2DtoList(List<IconoEntity> iconos){
		List<IconoListDto> entitys = new ArrayList<>();
		for (IconoEntity icono : iconos) {
			entitys.add(new IconoListDto(icono.getImagen(),icono.getDenominacion()));
		}
		return entitys;
	}

	public IconoDto iconoEntity2Dto(IconoEntity icono) {
		IconoDto entity = new IconoDto(icono.getId(),icono.getImagen(),icono.getDenominacion(),icono.getFechaCreacion(),icono.getAltura(),icono.getHistoria(),icono.getIdCiudad());
		List<CiudadDto> ciudadesDto = new ArrayList<>();
		for (CiudadEntity pais : icono.getCiudades()) {
			ciudadesDto.add(ciudadMapper.ciudadEntity2Dto(pais));
		}
		entity.setPaises(ciudadesDto);
		return entity;
	}
	
	public IconoEntity iconoDto2Entity(IconoDto icono) {
		IconoEntity icon = new IconoEntity();
		icon.setAltura(icono.getAltura());
		icon.setDenominacion(icono.getDenominacion());
		icon.setFechaCreacion(icon.getFechaCreacion());
		icon.setHistoria(icono.getHistoria());
		icon.setIdCiudad(icono.getIdCiudad());
		icon.setImagen(icono.getImagen());
		return icon;
	}
	
	public IconoEntity iconoUpdate(IconoEntity icon, IconoEntity iconUpdate) {
		icon.setAltura(iconUpdate.getAltura());
		icon.setDenominacion(iconUpdate.getDenominacion());
		icon.setHistoria(iconUpdate.getHistoria());
		return icon;
	}
}
