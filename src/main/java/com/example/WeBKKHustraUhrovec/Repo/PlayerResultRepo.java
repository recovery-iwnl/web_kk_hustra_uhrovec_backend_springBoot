package com.example.WeBKKHustraUhrovec.Repo;

import com.example.WeBKKHustraUhrovec.Entity.LeagueYear;
import com.example.WeBKKHustraUhrovec.Entity.Player;
import com.example.WeBKKHustraUhrovec.Entity.PlayerResult;
import com.example.WeBKKHustraUhrovec.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface PlayerResultRepo extends JpaRepository<PlayerResult,Integer> {

    void deleteByResult_ResultId(int resultId);

    @Query("SELECT MAX(pr.score) FROM PlayerResult pr WHERE pr.player = :player AND pr.result.leagueYear = :leagueYear")
    Integer findMaxScoreByPlayerAndResult_LeagueYear(@Param("player") Player player, @Param("leagueYear") LeagueYear leagueYear);

    @Query("SELECT MIN(pr.score) FROM PlayerResult pr WHERE pr.player = :player AND pr.result.leagueYear = :leagueYear")
    Integer findMinScoreByPlayerAndResult_LeagueYear(@Param("player") Player player, @Param("leagueYear") LeagueYear leagueYear);

    @Query("SELECT SUM(pr.score) FROM PlayerResult pr WHERE pr.player = :player AND pr.result.leagueYear = :leagueYear")
    Double sumScoreByPlayerAndResult_LeagueYear(@Param("player") Player player, @Param("leagueYear") LeagueYear leagueYear);

    long countByPlayerAndResult_LeagueYear(Player player, LeagueYear leagueYear);

    long countByPlayerAndMatchResult(Player player, String matchDuelResult);
}
