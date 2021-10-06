package com.alkemy.project.web.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.project.web.app.dto.CiudadDto;
import com.alkemy.project.web.app.entity.CiudadEntity;
import com.alkemy.project.web.app.mapper.CiudadMapper;
import com.alkemy.project.web.app.repository.CiudadRepository;
import com.alkemy.project.web.app.service.CiudadService;

@Service
public class CiudadServiceImpl implements CiudadService {

	@Autowired
	private CiudadRepository ciudadRepo;
	@Autowired
	private CiudadMapper ciudadMapper;
	
	@Override
	public List<CiudadDto> findall() {
		return this.ciudadMapper.ciudadEntity2DtoList(ciudadRepo.findAll());
	}

	@Override
	public CiudadEntity save(CiudadEntity ciudad) {
		//CiudadEntity citySaved = ciudadRepo.save(ciudad);
		//System.out.println(ciudad.getContinente().getDenominacion());
		//return ciudadMapper.ciudadEntity2Dto2(citySaved);
		return ciudadRepo.save(ciudad);
	}

	@Override
	public CiudadEntity getById(Long id) {
		return ciudadRepo.findById(id).orElse(null);
	}

	@Override
	public void deleteCity(CiudadEntity ciudad) {
		ciudadRepo.delete(ciudad);
	}

}
