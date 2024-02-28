package com.example.WeBKKHustraUhrovec.Repo;

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
    long countByTeam(Team team);

    int countByTeamAndMatchResult(Team team, String matchResult);

    void deleteByResult_ResultId(int resultId);

    @Query("SELECT SUM(tr.score) FROM TeamResult tr WHERE tr.team = :team")
    Double sumScoreByTeam(@Param("team") Team team);

}
