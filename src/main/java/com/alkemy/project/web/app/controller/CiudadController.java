package com.alkemy.project.web.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.project.web.app.dto.CiudadDto;
import com.alkemy.project.web.app.entity.CiudadEntity;
import com.alkemy.project.web.app.mapper.CiudadMapper;
import com.alkemy.project.web.app.service.CiudadService;

@RestController
@RequestMapping("/api")
public class CiudadController {
	@Autowired
	private CiudadService ciudadService;
	@Autowired
	private CiudadMapper ciudadMapper;
	
	@GetMapping("/ciudad")
	public @ResponseBody List<CiudadDto> getAll(){
		return ciudadService.findall();
	}
	
	@PostMapping("/ciudad")
	public @ResponseBody CiudadDto save(@RequestBody CiudadEntity ciudad) {
		return ciudadService.save(ciudad);
	}
	
	@PutMapping("/ciudad/{id}")
	public @ResponseBody CiudadDto update(@PathVariable Long id,@RequestBody CiudadDto ciudad) {
		CiudadEntity city = ciudadService.getById(id);
		if(city != null) {
			ciudadMapper.CiudadDto2EntityUpdate(ciudad, city);
			return ciudadService.save(city);
		}
		return null;
	}
	
	@DeleteMapping("/ciudad/{id}")
	public @ResponseBody String deleteCity(@PathVariable Long id) {
		CiudadEntity city = ciudadService.getById(id);
		if(city != null) {
			ciudadService.deleteCity(city);
			return "Ciudad eliminada con exito";
		}
		return "La ciudad no se encuentra registrada";
	}
}
