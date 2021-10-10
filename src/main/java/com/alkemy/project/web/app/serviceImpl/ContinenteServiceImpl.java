package com.alkemy.project.web.app.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alkemy.project.web.app.dto.ContinenteDto;
import com.alkemy.project.web.app.entity.ContinenteEntity;
import com.alkemy.project.web.app.mapper.ContinenteMapper;
import com.alkemy.project.web.app.repository.ContinenteRepository;
import com.alkemy.project.web.app.service.IContinenteService;

@Service
public class ContinenteServiceImpl implements IContinenteService{

	@Autowired
	private ContinenteRepository continenteRepository;
	@Autowired
	private ContinenteMapper continenteMapper;
	
	@Override
	@Transactional
	public ContinenteDto save(ContinenteEntity continente) {
		ContinenteEntity cont = this.continenteRepository.save(continente);
		return continenteMapper.continenteEntity2Dto(cont);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ContinenteDto> getAll() {
		return continenteMapper.continenteEntity2DtoList(this.continenteRepository.findAll());
	}
	
	public ContinenteEntity getById(Long id) {
		return continenteRepository.getById(id);
	}
}
