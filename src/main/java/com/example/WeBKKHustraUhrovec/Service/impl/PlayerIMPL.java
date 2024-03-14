package com.example.WeBKKHustraUhrovec.Service.impl;

import com.example.WeBKKHustraUhrovec.Entity.Player;
import com.example.WeBKKHustraUhrovec.Entity.Result;
import com.example.WeBKKHustraUhrovec.Entity.Team;
import com.example.WeBKKHustraUhrovec.Entity.TeamResult;
import com.example.WeBKKHustraUhrovec.Repo.*;
import com.example.WeBKKHustraUhrovec.Service.PlayerService;
import com.example.WeBKKHustraUhrovec.Service.ResultService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerIMPL implements PlayerService {

    @Autowired
    private PlayerRepo playerRepo;

    @Autowired
    private TeamRepo teamRepo;

    @Autowired
    private ResultRepo resultRepo;

    @Autowired
    private TeamResultRepo teamResultRepo;

    @Autowired
    private PlayerResultRepo playerResultRepo;

    @Autowired
    private ResultService resultService;

    @Override
    public Player addPlayer(String id, Player player) {
        Team teamO = teamRepo.findById(Integer.valueOf(id)).orElse(null);
        player.setTeam(teamO);
        return playerRepo.save(player);
    }

    @Override
    public Player addPlayerUhrovec(Player player) {
        Team teamO = teamRepo.findTeamByTeamName("KK Hustra Uhrovec").orElse(null);
        player.setTeam(teamO);
        return playerRepo.save(player);
    }

    @Override
    public Optional<Player> getPlayer(String id) {
        return playerRepo.findById(Integer.valueOf(id));
    }

    @Override
    public String getAge(String id) {
        Player player = playerRepo.findById(Integer.valueOf(id)).orElse(null);
        assert player != null;
        return String.valueOf(player.getAge());
    }

    @Override
    public Optional<Player> getPlayerByName(String name, String surname) {
        return playerRepo.findPlayerByNameAndSurname(name, surname);
    }

    @Override
    public Optional<String> getTeamNameByPlayer(int id) {
        return playerRepo.findTeamNameByPlayerId(id);
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepo.findAll();
    }

    @Override
    @Transactional
    public String deletePlayer(Integer id) {
        Player player = playerRepo.findById(id).orElse(null);
        if (player == null) {
            return "Player doesn't exist";
        } else {
            try {
                List<Result> results = resultRepo.findAllByPlayer1HomeOrPlayer2HomeOrPlayer3HomeOrPlayer4HomeOrPlayer5HomeOrPlayer6HomeOrPlayer1AwayOrPlayer2AwayOrPlayer3AwayOrPlayer4AwayOrPlayer5AwayOrPlayer6Away
                        (player, player, player, player, player, player, player, player, player, player, player, player);
                for (Result result : results) {
                    resultService.deleteResult(result.getResultId());
                }
                playerRepo.delete(player);
                return "Player " + player.getName() + " " + player.getSurname() + " was deleted";
            } catch (Exception e) {
                return "Failed to delete player: " + e.getMessage();
            }
        }
    }

    @Override
    public Player updatePlayer(Player player) {
        Player playerN = playerRepo.findById(player.getPlayerID()).orElse(null);
        if (playerN != null) {
            Team teamN = teamRepo.findById(playerN.getTeam().getTeamId()).orElse(null);
            playerN.setName(player.getName());
            playerN.setSurname(player.getSurname());
            playerN.setAge(player.getAge());
            playerN.setTeam(teamN);
            return playerRepo.save(playerN);
        } else {
            return null;
        }
    }
}
