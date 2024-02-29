package com.example.WeBKKHustraUhrovec.Repo;

import com.example.WeBKKHustraUhrovec.Entity.LeagueYear;
import com.example.WeBKKHustraUhrovec.Entity.Player;
import com.example.WeBKKHustraUhrovec.Entity.Team;
import com.example.WeBKKHustraUhrovec.Entity.TeamResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface TeamResultRepo extends JpaRepository<TeamResult,Integer> {

    long countByTeamAndResult_LeagueYear(Team team, LeagueYear leagueYear);

    @Query("SELECT COUNT(tr) FROM TeamResult tr WHERE tr.team = :team AND tr.matchResult = :matchResult AND tr.result.leagueYear = :leagueYear")
    int countByTeamAndMatchResultAndResult_LeagueYear(Team team, String matchResult, LeagueYear leagueYear);

    void deleteByResult_ResultId(int resultId);

    @Query("SELECT SUM(tr.score) FROM TeamResult tr WHERE tr.team = :team AND tr.result.leagueYear = :leagueYear")
    Double sumScoreByTeamAndResult_LeagueYear(@Param("team") Team team, @Param("leagueYear") LeagueYear leagueYear);

}
