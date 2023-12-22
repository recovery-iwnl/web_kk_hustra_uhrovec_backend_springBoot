package com.example.WeBKKHustraUhrovec.Service.impl;

import com.example.WeBKKHustraUhrovec.Entity.Player;
import com.example.WeBKKHustraUhrovec.Entity.User;
import com.example.WeBKKHustraUhrovec.Repo.PlayerRepo;
import com.example.WeBKKHustraUhrovec.Service.PlayerService;
import com.example.WeBKKHustraUhrovec.exception.UserUpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PlayerIMPL implements PlayerService {

    @Autowired
    private PlayerRepo playerRepo;
    @Override
    public Player addPlayer(Player player) {
        Player playerN = player;
        playerRepo.save(playerN);
        return playerN;
    }

    @Override
    public Optional<Player> getPlayer(String id) {
        return playerRepo.findById(Integer.valueOf(id));
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepo.findAll();
    }

    @Override
    public String deletePlayer(Integer id) {
        Player player = playerRepo.findById(id).orElse(null);
        if (player == null) {
            return "Player doesn't exist";
        } else {
            playerRepo.deleteById(id);
            return "Player " + player.getName() + " " + player.getSurname() + " was deleted";
        }
    }

    @Override
    public Player updatePlayer(Player player) {
        Player playerN = playerRepo.findById(player.getPlayerID()).orElse(null);
        System.out.println("Updated player data: " + playerN);
        if (playerN != null) {
            playerN.setName(player.getName());
            playerN.setSurname(player.getSurname());
            playerN.setAge(player.getAge());
            playerN.setPoints(player.getPoints());
            return playerRepo.save(playerN);
        } else {
            return null;
        }
    }
}
