package com.diogorolins.battleShip.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.diogorolins.battleShip.config.security.TokenService;
import com.diogorolins.battleShip.model.dto.LoginDTO;
import com.diogorolins.battleShip.model.dto.TokenDTO;
import com.diogorolins.battleShip.services.AuthService;
import com.diogorolins.battleShip.services.PlayerService;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@RequestMapping(method  = RequestMethod.POST)
	public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO objDTO ){
		UsernamePasswordAuthenticationToken authentication = authService.convertToLogin(objDTO);
		Authentication authenticationData = authManager.authenticate(authentication);
		String token = tokenService.generateToken(authenticationData);
		playerService.setPlayerLogged(tokenService.getUsername(token));
		return ResponseEntity.ok().body(new TokenDTO(token, "Bearer"));
	}
	
	
}
