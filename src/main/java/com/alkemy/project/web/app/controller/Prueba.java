package com.alkemy.project.web.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/icon")
@CrossOrigin("*")
public class Prueba {
	@GetMapping
	public String getIcons() {
		return "ok";
	}
}
