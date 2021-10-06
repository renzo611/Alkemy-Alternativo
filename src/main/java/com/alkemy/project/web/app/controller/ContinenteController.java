package com.alkemy.project.web.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.project.web.app.dto.ContinenteDto;
import com.alkemy.project.web.app.entity.ContinenteEntity;
import com.alkemy.project.web.app.serviceImpl.ContinenteServiceImpl;

@RestController
@RequestMapping("/api")
public class ContinenteController {
	
	@Autowired
	private ContinenteServiceImpl contService;
	
	@GetMapping("/continente")
	public @ResponseBody List<ContinenteDto> getall(){
		return contService.getAll();
	}
	
	@PostMapping("/continente")
	public @ResponseBody ContinenteEntity save(@RequestBody ContinenteEntity continente) {
		return contService.save(continente);
	}
}
