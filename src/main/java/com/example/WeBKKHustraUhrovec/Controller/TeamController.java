package com.example.WeBKKHustraUhrovec.Controller;


import com.example.WeBKKHustraUhrovec.Entity.Player;
import com.example.WeBKKHustraUhrovec.Entity.Team;
import com.example.WeBKKHustraUhrovec.Service.PlayerService;
import com.example.WeBKKHustraUhrovec.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/v1/team")
public class TeamController {

    @Autowired
    private TeamService teamService;


    @PostMapping(path = "/save")
    public Team saveTeam(@RequestBody Team team) {
        return teamService.addTeam(team);
    }

    @GetMapping(path = "/getTeam")
    public Optional<Team> getTeam(@RequestParam String id) {
        return teamService.getTeam(id);
    }

    @GetMapping(path = "/getTeamByName")
    public Optional<Team> getTeamByName(@RequestParam String name) {
        return teamService.getTeamByName(name);
    }

    @GetMapping(path = "/getTeamsList")
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @DeleteMapping(path = "/deleteTeam")
    public String deleteTeam(@RequestParam Integer id) {
        return teamService.deleteTeam(id);
    }
    @PutMapping(path = "/updateTeam")
    public Team updateTeam(@RequestBody Team team) {
        return teamService.updateTeam(team);
    }

    @GetMapping(path = "/playersByTeam")
    public List<Player> getPlayersByTeam(@RequestParam String id) {
        return teamService.getPlayers(id);
    }

    @GetMapping(path = "/playersUhrovec")
    public List<Player> getPlayersByTeam() {
        return teamService.getPlayersUhrovec();
    }




}
