package com.demo.ipldashboard.repository;

import com.demo.ipldashboard.model.Team;

import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team,Long>{

    Team findByTeamName(String teamName);

    
    
}
