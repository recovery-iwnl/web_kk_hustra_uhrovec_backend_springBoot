package com.example.WeBKKHustraUhrovec.Repo;

import com.example.WeBKKHustraUhrovec.Entity.Player;
import com.example.WeBKKHustraUhrovec.Entity.PlayerResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface PlayerResultRepo extends JpaRepository<PlayerResult,Integer> {

    void deleteByResult_ResultId(int resultId);

    @Query("SELECT MAX(pr.score) FROM PlayerResult pr WHERE pr.player = :player")
    Integer findMaxScoreByPlayer(@Param("player") Player player);

    @Query("SELECT SUM(pr.score) FROM PlayerResult pr WHERE pr.player = :player")
    Double sumScoreByPlayer(@Param("player") Player player);
    long countByPlayer(Player player);
}
