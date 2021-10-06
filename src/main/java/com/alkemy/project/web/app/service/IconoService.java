package com.alkemy.project.web.app.service;

import java.util.List;

import com.alkemy.project.web.app.dto.IconoDto;
import com.alkemy.project.web.app.entity.IconoEntity;

public interface IconoService {
	public IconoDto save(IconoEntity entity);
	public List<IconoDto> findAll();
	public void deleteIcono(IconoEntity entity);
	public IconoEntity getById(Long id);
}
