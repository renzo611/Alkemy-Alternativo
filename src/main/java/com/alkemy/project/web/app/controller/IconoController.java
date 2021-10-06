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

import com.alkemy.project.web.app.dto.IconoDto;
import com.alkemy.project.web.app.entity.IconoEntity;
import com.alkemy.project.web.app.serviceImpl.IconoServiceImpl;

@RestController
@RequestMapping("/api")
public class IconoController {
	@Autowired
	private IconoServiceImpl iconoService;
	
	
	@GetMapping("/icono")
	public @ResponseBody List<IconoDto> getAll(){
		return iconoService.findAll(); 
	}
	
	@PostMapping("/icono")
	public @ResponseBody IconoDto save(@RequestBody IconoEntity icono) {
		return iconoService.save(icono);
	}
	
	@PutMapping("/icono/{id}")
	public @ResponseBody IconoDto update(@PathVariable Long id, @RequestBody IconoEntity icono) {
		IconoEntity entity = iconoService.getById(id);
		if(entity != null) {
			entity.setAltura(icono.getAltura());
			entity.setDenominacion(icono.getDenominacion());
			//entity.setFechaCreacion(icono.getFechaCreacion());
			entity.setHistoria(icono.getHistoria());
			return iconoService.save(entity);
		}
		return null;
	}
	
	@DeleteMapping("/icono/{id}")
	public @ResponseBody String delete(@PathVariable Long id) {
		IconoEntity entity = iconoService.getById(id);
		if(entity != null) {
			iconoService.deleteIcono(entity);
			return "Icono eliminado";
		}
		return "El icono no esta registrado";
	}
}
