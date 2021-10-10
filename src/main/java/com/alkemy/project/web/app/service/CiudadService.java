package com.alkemy.project.web.app.service;

import java.util.List;

import com.alkemy.project.web.app.dto.CiudadDto;
import com.alkemy.project.web.app.entity.CiudadEntity;

public interface CiudadService {
	public List<CiudadDto> findall();
	public CiudadDto save(CiudadEntity ciudad);
	public CiudadEntity getById(Long id);
	public void deleteCity(CiudadEntity ciudad);
}
