package com.alkemy.project.web.app.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alkemy.project.web.app.dto.IconoDto;
import com.alkemy.project.web.app.entity.IconoEntity;

@Component
public class IconoMapper {
	public List<IconoDto> iconoEntity2DtoList(List<IconoEntity> iconos){
		List<IconoDto> entitys = new ArrayList<>();
		IconoDto entity; 
		for (IconoEntity icono : iconos) {
			entity = this.iconoEntity2Dto(icono);
			entitys.add(entity);
		}
		return entitys;
	}

	public IconoDto iconoEntity2Dto(IconoEntity icono) {
		IconoDto entity = new IconoDto(icono.getDenominacion(),icono.getImagen());
		return entity;
	}
	
	public IconoDto iconoEntity2DtoVista(IconoEntity icono) {
		IconoDto entity = new IconoDto( icono.getId(),icono.getDenominacion(),icono.getImagen());
		return entity;
	}
}
