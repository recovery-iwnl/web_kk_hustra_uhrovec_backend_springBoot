package com.example.WeBKKHustraUhrovec.Repo;

import com.example.WeBKKHustraUhrovec.Entity.LeagueYear;
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

}
