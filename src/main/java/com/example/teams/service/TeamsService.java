package com.example.teams.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.teams.entity.Teams;
import com.example.teams.repository.TeamsRepository;


@Service
public class TeamsService {

	@Autowired
	TeamsRepository teamsRepo;
	
	public List<Teams> getAllTeams(){
		
		/* write your code here */
		return null;
	}

}
