package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.domain.dto.DadosCadastroGame;
import com.devsuperior.dslist.domain.dto.GameMinDTO;
import com.devsuperior.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {

	@Autowired
	private GameService gameService;
	
	@GetMapping
	public ResponseEntity<List<GameMinDTO>> listarGames() {
		var listaDeGames = gameService.listarGames();
		return ResponseEntity.ok(listaDeGames);
	}
	
	@PostMapping
	public void cadastrarGame(@RequestBody DadosCadastroGame dados) {
		gameService.cadastrarGame(dados);
		

	}
}
