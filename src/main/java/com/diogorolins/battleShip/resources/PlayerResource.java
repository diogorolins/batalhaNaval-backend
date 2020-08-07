package com.diogorolins.battleShip.resources;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.diogorolins.battleShip.config.security.TokenService;
import com.diogorolins.battleShip.model.Player;
import com.diogorolins.battleShip.model.dto.PlayerCreateDTO;
import com.diogorolins.battleShip.services.PlayerService;

@RestController
@RequestMapping(value = "/players")
public class PlayerResource {
	
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private TokenService tokenService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Player>> findAll(){
		List<Player> players = playerService.findAll();
		return  ResponseEntity.ok().body(players);
	};
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Player> findById(@PathVariable Integer id){
		Player player = playerService.findById(id);
		return  ResponseEntity.ok().body(player);
	};
	
	@RequestMapping(method = RequestMethod.GET, value = "/email")
	public ResponseEntity<Player> findByEmail(@RequestParam(value = "email") String email){
		Player player = playerService.findyEmail(email);
		return  ResponseEntity.ok().body(player);
	};
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<PlayerCreateDTO> insert(@RequestBody @Valid PlayerCreateDTO objDto){
		Player player = playerService.convertFromDto(objDto);
		player = playerService.insert(player);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(player.getId()).toUri();
		return ResponseEntity.created(uri).body(new PlayerCreateDTO(player));
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/logged")
	public ResponseEntity<List<Player>> findLoggedPlayers( HttpServletRequest request){
		String emailPlayer = tokenService.getUsername(tokenService.getToken(request));
		List<Player> players = playerService.findLoggedPlayers(emailPlayer);
		return ResponseEntity.ok().body(players);
	}
	
	
	
	
	
}
