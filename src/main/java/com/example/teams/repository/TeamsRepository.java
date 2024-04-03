package com.example.teams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.teams.entity.Teams;

@Repository
public interface TeamsRepository extends JpaRepository<Teams, Integer>{

}
