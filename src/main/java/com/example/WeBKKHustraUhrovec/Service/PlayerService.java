package com.example.WeBKKHustraUhrovec.Service;

import com.example.WeBKKHustraUhrovec.Entity.Player;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PlayerService {

    Player addPlayer(String id, Player player);

    Optional<Player> getPlayer(String id);

    List<Player> getAllPlayers();

    String deletePlayer(Integer id);

    Player updatePlayer(Player player);

}
