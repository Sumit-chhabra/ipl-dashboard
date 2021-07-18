package com.demo.ipldashboard.repository;

import java.util.List;

import com.demo.ipldashboard.model.Match;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<Match,Long> {
    
    List<Match> getByTeam1OrTeam2OrderByDateDesc(String teamName, String team2, Pageable pageable);

    default List<Match> findLatestMatchesbyTeam(String teamName, int count){

        return getByTeam1OrTeam2OrderByDateDesc(teamName, teamName, PageRequest.of(0, count));
    }
}
