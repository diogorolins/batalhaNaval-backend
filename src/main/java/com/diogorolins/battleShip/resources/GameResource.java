package com.diogorolins.battleShip.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.diogorolins.battleShip.model.Game;
import com.diogorolins.battleShip.model.dto.GameDTO;
import com.diogorolins.battleShip.model.dto.ShipDTO;
import com.diogorolins.battleShip.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameResource {

	@Autowired
	private GameService gameService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Game>> findAll() {
		List<Game> games = gameService.findAll();
		return ResponseEntity.ok().body(games);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Game> findById(@PathVariable Integer id){
		Game game = gameService.findById(id);
		return ResponseEntity.ok().body(game);
		
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Game> insert(@RequestBody GameDTO objDto) {
		Game game = gameService.convertFromDTO(objDto);
		game = gameService.createGame(game);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(game.getId()).toUri();
		return ResponseEntity.created(uri).body(game);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<Game> addShips(@RequestBody List<ShipDTO> shipsDTO, @PathVariable Integer id) {
		Game game = gameService.insertShips(shipsDTO, id);
		return ResponseEntity.ok().body(game);

	}
	
	
}
