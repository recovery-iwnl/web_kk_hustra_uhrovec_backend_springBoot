package com.example.WeBKKHustraUhrovec.Service;

import com.example.WeBKKHustraUhrovec.Entity.Player;
import com.example.WeBKKHustraUhrovec.Entity.Team;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PlayerService {

    Player addPlayer(String id, Player player);

    Player addPlayerUhrovec(Player player);

    Optional<Player> getPlayer(String id);

    String getAge(String id);
    Optional<Player> getPlayerByName(String name,String surname);

    Optional<String> getTeamNameByPlayer(int id);

    List<Player> getAllPlayers();

    String deletePlayer(Integer id);

    Player updatePlayer(Player player);

}
