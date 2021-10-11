package com.alkemy.project.web.app.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.project.web.app.dto.CiudadDto;
import com.alkemy.project.web.app.entity.CiudadEntity;
import com.alkemy.project.web.app.mapper.CiudadMapper;
import com.alkemy.project.web.app.service.CiudadService;


@RestController
@RequestMapping("/cities")
public class CiudadController {
	@Autowired
	private CiudadService ciudadService;
	@Autowired
	private CiudadMapper ciudadMapper;
	
	@GetMapping
	public ResponseEntity<List<CiudadDto>> getAll(){
		return ResponseEntity.ok().body(ciudadService.findall());
	}
	
	@PostMapping
	public ResponseEntity<CiudadDto> save(@RequestBody CiudadEntity ciudad) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ciudadService.save(ciudad));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id,@RequestBody CiudadDto ciudad) {
		CiudadEntity city = ciudadService.getById(id);
		if(city != null) {
			ciudadMapper.CiudadDto2EntityUpdate(ciudad, city);
			return ResponseEntity.ok().body(ciudadService.save(city));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCity(@PathVariable Long id) {
		CiudadEntity city = ciudadService.getById(id);
		if(city != null) {
			ciudadService.deleteCity(city);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@GetMapping
	public ResponseEntity<?> getByDenominacion(@RequestParam String name){
		List<CiudadDto> ciudades = ciudadService.findByDenominacion(name);
		return ResponseEntity.ok().body(ciudades);
	}
	
	@GetMapping
	public ResponseEntity<?> getByContinente(@RequestParam String continent){
		try {
			Long idContinent = Long.valueOf(continent);
			List<CiudadDto> ciudades = ciudadService.findByContinenteId(idContinent);
			return ResponseEntity.ok().body(ciudades);
		}catch(NumberFormatException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	//Falta agregar metodo para filtrar por fecha...
}
