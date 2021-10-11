package com.alkemy.project.web.app.serviceImpl;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alkemy.project.web.app.dto.IconoDto;
import com.alkemy.project.web.app.dto.IconoListDto;
import com.alkemy.project.web.app.entity.IconoEntity;
import com.alkemy.project.web.app.mapper.IconoMapper;
import com.alkemy.project.web.app.repository.IconoRepository;
import com.alkemy.project.web.app.service.IconoService;

@Service
public class IconoServiceImpl implements IconoService{
	
	@Autowired
	private IconoRepository iconoRepo;
	@Autowired 
	private IconoMapper iconMapper;
	
	@Override
	@Transactional
	public IconoDto save(IconoEntity entity) {
		entity.setFechaCreacion(new Date());
		IconoEntity iconsSave = iconoRepo.save(entity);
		return this.iconMapper.iconoEntity2Dto(iconsSave);
	}

	@Override
	@Transactional(readOnly = true)
	public List<IconoListDto> findAll() {
		return iconMapper.iconoEntity2DtoList(iconoRepo.findAll());
	}

	@Override
	@Transactional
	public void deleteIcono(IconoEntity entity) {
		iconoRepo.delete(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public IconoEntity getById(Long id) {
		return iconoRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<IconoListDto> findByName(String name) {
		List<IconoEntity> iconos = iconoRepo.findByDenominacion(name);
		return iconMapper.iconoEntity2DtoList(iconos);
	}

	@Override
	@Transactional(readOnly = true)
	public List<IconoListDto> findByFechaCreacion(Date fechaCreacion) {
		return iconMapper.iconoEntity2DtoList(iconoRepo.findFechaCreacion(fechaCreacion));
	}

}
