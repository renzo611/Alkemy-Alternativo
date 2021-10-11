package com.alkemy.project.web.app.service;

import java.util.Date;
import java.util.List;

import com.alkemy.project.web.app.dto.IconoDto;
import com.alkemy.project.web.app.dto.IconoListDto;
import com.alkemy.project.web.app.entity.IconoEntity;

public interface IconoService {
	public IconoDto save(IconoEntity entity);
	public List<IconoListDto> findAll();
	public List<IconoListDto> findByName(String name);
	public List<IconoListDto> findByFechaCreacion(Date fechaCreacion);
	public void deleteIcono(IconoEntity entity);
	public IconoEntity getById(Long id);
}
