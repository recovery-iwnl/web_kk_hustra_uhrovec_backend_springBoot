package com.example.WeBKKHustraUhrovec.Repo;

import com.example.WeBKKHustraUhrovec.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@EnableJpaRepositories
@Repository
public interface PlayerRepo extends JpaRepository<Player,Integer> {
    Optional<Player> findPlayerByNameAndSurname(String name, String surname);

    @Query("SELECT p.team.teamName FROM Player p WHERE p.playerID = :playerId")
    Optional<String> findTeamNameByPlayerId(int playerId);

}
