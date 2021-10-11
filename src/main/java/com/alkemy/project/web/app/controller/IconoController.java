package com.alkemy.project.web.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.alkemy.project.web.app.dto.IconoDto;
import com.alkemy.project.web.app.dto.IconoListDto;
import com.alkemy.project.web.app.entity.IconoEntity;
import com.alkemy.project.web.app.mapper.IconoMapper;
import com.alkemy.project.web.app.serviceImpl.IconoServiceImpl;

@RestController
@RequestMapping("/icons")
public class IconoController {
	@Autowired
	private IconoServiceImpl iconoService;
	@Autowired
	private IconoMapper iconoMapping;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		IconoEntity icono= iconoService.getById(id);
		if(icono != null) {
			IconoDto icon = iconoMapping.iconoEntity2Dto(icono);
			return ResponseEntity.ok().body(icon);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@GetMapping
	public ResponseEntity<List<IconoListDto>> getByNombre(@RequestParam String name){
		return ResponseEntity.ok().body(iconoService.findByName(name));
	}
	
	@GetMapping
	public ResponseEntity<?> getByFechaCreacion(@RequestParam String date){
		try {
			Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
			return ResponseEntity.ok().body(iconoService.findByFechaCreacion(date1));
		} catch (ParseException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping
	public ResponseEntity<List<IconoListDto>> getAll(){
		return ResponseEntity.ok().body(iconoService.findAll()); 
	}
	
	@PostMapping
	public ResponseEntity<IconoDto> save(@RequestBody IconoEntity icono) {
		return ResponseEntity.status(HttpStatus.CREATED).body(iconoService.save(icono));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody IconoEntity icono) {
		IconoEntity entity = iconoService.getById(id);
		if(entity != null) {
			return ResponseEntity.ok().body(iconoService.save(iconoMapping.iconoUpdate(entity, icono)));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		IconoEntity entity = iconoService.getById(id);
		if(entity != null) {
			iconoService.deleteIcono(entity);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	
}
