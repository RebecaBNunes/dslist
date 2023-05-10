package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.domain.dto.DadosCadastroGame;
import com.devsuperior.dslist.domain.dto.GameMinDTO;
import com.devsuperior.dslist.domain.entities.games.Game;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	public List<GameMinDTO> listarGames() {
		List<Game> resultado = gameRepository.findAll();
		return resultado.stream().map(game -> new GameMinDTO(game)).toList();
	}

	public GameMinDTO cadastrarGame(DadosCadastroGame dados) {
		var game = new Game(dados);
		gameRepository.save(game);
		return new GameMinDTO(game);
	}
	
}
