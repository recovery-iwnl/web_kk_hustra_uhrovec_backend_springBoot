package com.example.WeBKKHustraUhrovec.Repo;

import com.example.WeBKKHustraUhrovec.Entity.LeagueYear;
import com.example.WeBKKHustraUhrovec.Entity.Player;
import com.example.WeBKKHustraUhrovec.Entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface ResultRepo extends JpaRepository<Result,Integer> {
    List<Result> findAllByOrderByDateDesc();

    List<Result> findAllByLeagueYearOrderByDateDesc(LeagueYear leagueYear);

    List<Result> findAllByLeagueYearAndTeamHome_TeamNameOrLeagueYearAndTeamAway_TeamNameOrderByDateDesc(LeagueYear leagueYear, String teamNameHome, LeagueYear leagueYear2, String teamNameAway);

    List<Result> findAllByPlayer1HomeOrPlayer2HomeOrPlayer3HomeOrPlayer4HomeOrPlayer5HomeOrPlayer6HomeOrPlayer1AwayOrPlayer2AwayOrPlayer3AwayOrPlayer4AwayOrPlayer5AwayOrPlayer6Away
            (Player player, Player player1, Player player2, Player player3, Player player4, Player player5, Player player6, Player player7, Player player8, Player player9, Player player10, Player player11);

}
