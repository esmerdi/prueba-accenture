package com.eduran.prueba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
public class TestRestController {
	
	@GetMapping("/saludo")
	public String saludo() {
		return "hola mundo";
	}

}
