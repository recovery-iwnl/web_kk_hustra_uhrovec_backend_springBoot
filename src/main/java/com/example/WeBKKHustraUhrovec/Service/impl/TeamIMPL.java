package com.example.WeBKKHustraUhrovec.Service.impl;

import com.example.WeBKKHustraUhrovec.Entity.Player;
import com.example.WeBKKHustraUhrovec.Entity.Team;
import com.example.WeBKKHustraUhrovec.Repo.PlayerRepo;
import com.example.WeBKKHustraUhrovec.Repo.TeamRepo;
import com.example.WeBKKHustraUhrovec.Service.TeamService;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamIMPL implements TeamService {
    @Autowired
    private TeamRepo teamRepo;

    @Autowired
    private PlayerRepo playerRepo;

    @Override
    public Team addTeam(Team team) {
        return teamRepo.save(team);
    }

    @Override
    public Optional<Team> getTeam(String id) {
        return teamRepo.findById(Integer.valueOf(id));
    }

    @Override
    public List<Team> getAllTeams() {
        List<Team> teams = teamRepo.findAll();
        return teams;
    }

    @Override
    public String deleteTeam(Integer id) {
        Team team = teamRepo.findById(id).orElse(null);
        if(team == null) {
            return "Team doesn't exist";
        } else {
            teamRepo.deleteById(id);
            return "Team " + team.getTeamName()  + " was deleted";
        }
    }

    @Override
    public Team updateTeam(Team team) {
        Team teamN = teamRepo.findById(team.getTeamId()).orElse(null);
        if (teamN != null) {
            teamN.setTeamName(team.getTeamName());
            return teamRepo.save(teamN);
        } else {
            return null;
        }
    }

    @Override
    public List<Player> getPlayers(String teamId) {
        Optional<Team> teamOptional = teamRepo.findById(Integer.valueOf(teamId));
        return teamOptional.map(Team::getPlayers).orElse(null);
    }

    @Override
    public List<Player> getPlayersUhrovec() {
        Optional<Team> teamOptional = teamRepo.findTeamByTeamName("KK Hustra Uhrovec");
        return teamOptional.map(Team::getPlayers).orElse(null);
    }
}
