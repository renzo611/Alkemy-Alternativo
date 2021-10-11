package com.alkemy.project.web.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.project.web.app.dto.ContinenteDto;
import com.alkemy.project.web.app.dto.ContinenteListDto;
import com.alkemy.project.web.app.entity.ContinenteEntity;
import com.alkemy.project.web.app.serviceImpl.ContinenteServiceImpl;

@RestController
@RequestMapping("/continente")
public class ContinenteController {
	
	@Autowired
	private ContinenteServiceImpl contService;
	
	@GetMapping
	public ResponseEntity<List<ContinenteListDto>> getall(){
		List<ContinenteListDto> continentes = contService.getAll();
		return ResponseEntity.ok().body(continentes);
	}
	
	@PostMapping
	public ResponseEntity<ContinenteDto> save(@RequestBody ContinenteEntity continente) {
		return ResponseEntity.status(HttpStatus.CREATED).body(contService.save(continente));
	}
}
