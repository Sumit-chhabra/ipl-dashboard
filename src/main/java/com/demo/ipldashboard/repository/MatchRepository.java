package com.demo.ipldashboard.repository;

import java.time.LocalDate;
import java.util.List;

import com.demo.ipldashboard.model.Match;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MatchRepository extends CrudRepository<Match,Long> {
    
    List<Match> getByTeam1OrTeam2OrderByDateDesc(String teamName, String team2, Pageable pageable);

    @Query("select m from Match m where (m.team1 = :teamName or m.team2 = :teamName) and m.date between :dateStart and :dateEnd order by date desc")
    List<Match> getMatchesByTeamBetweenDates(@Param("teamName") String teamName, 
    @Param("dateStart") LocalDate startDate, 
    @Param("dateEnd") LocalDate endDate);

    default List<Match> findLatestMatchesbyTeam(String teamName, int count){

        return getByTeam1OrTeam2OrderByDateDesc(teamName, teamName, PageRequest.of(0, count));
    }
}
