package com.example.teams.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.teams.entity.Teams;
import com.example.teams.service.TeamsService;



@RestController
public class TeamsController {

	@Autowired
	TeamsService teamsService;
	
	@GetMapping(path = "/winning_teams")
	public ResponseEntity<List<Teams>> getAllWinningTeams(){
		
		/* write your code here */
		return new ResponseEntity<>(null);
		
	}
	
	@GetMapping(path = "/team_2013")
    public ResponseEntity<List<Teams>> getTeamsIn2013(){
		
		/* write your code here */
		return new ResponseEntity<>(null);
	
	}

}
