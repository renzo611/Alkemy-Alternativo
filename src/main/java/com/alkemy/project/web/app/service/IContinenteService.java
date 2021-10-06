package com.alkemy.project.web.app.service;

import java.util.List;

import com.alkemy.project.web.app.dto.ContinenteDto;
import com.alkemy.project.web.app.entity.ContinenteEntity;

public interface IContinenteService {
	public ContinenteEntity save(ContinenteEntity continenete);
	public List<ContinenteDto> getAll();
	
}
