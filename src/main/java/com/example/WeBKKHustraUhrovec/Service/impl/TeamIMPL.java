package com.example.WeBKKHustraUhrovec.Service.impl;

import com.example.WeBKKHustraUhrovec.Entity.Player;
import com.example.WeBKKHustraUhrovec.Entity.Team;
import com.example.WeBKKHustraUhrovec.Repo.PlayerRepo;
import com.example.WeBKKHustraUhrovec.Repo.TeamRepo;
import com.example.WeBKKHustraUhrovec.Service.TeamService;
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
        Team teamN = new Team(team.getTeamName(),0,0,0,0,0,0);
        return teamRepo.save(teamN);
    }

    @Override
    public Optional<Team> getTeam(String id) {
        return teamRepo.findById(Integer.valueOf(id));
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepo.findAll();
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
            teamN.setPoints(team.getPoints());
            teamN.setAverageThrownFrames(team.getAverageThrownFrames());
            teamN.setMatchesWon(team.getMatchesWon());
            teamN.setMatchesLost(team.getMatchesLost());
            teamN.setMatchesDraw(team.getMatchesDraw());
            teamN.setMatchesPlayed(team.getMatchesPlayed());
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
}
