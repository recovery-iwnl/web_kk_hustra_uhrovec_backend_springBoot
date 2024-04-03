package com.example.WeBKKHustraUhrovec.Controller;


import com.example.WeBKKHustraUhrovec.Entity.Player;
import com.example.WeBKKHustraUhrovec.Entity.Team;
import com.example.WeBKKHustraUhrovec.Entity.User;
import com.example.WeBKKHustraUhrovec.Enum.UserRole;
import com.example.WeBKKHustraUhrovec.Service.PlayerService;
import com.example.WeBKKHustraUhrovec.Service.TeamService;
import com.example.WeBKKHustraUhrovec.Service.UserService;
import com.example.WeBKKHustraUhrovec.jwt.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/v1/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @PostMapping(path = "/save")
    public ResponseEntity<Team> saveTeam(@RequestBody Team team,
                                         @RequestHeader(value = "Authorization", required = false) String token) {
        if (token == null || jwtTokenUtil.isTokenExpired(token.substring(7))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        User user = userService.getUserByToken(token.substring(7));
        if (user.getRole() != UserRole.ADMIN) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }

        Team savedTeam = teamService.addTeam(team);
        return ResponseEntity.ok(savedTeam);
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
    public ResponseEntity<String> deleteTeam(@RequestParam Integer id,
                                             @RequestHeader(value = "Authorization", required = false) String token) {
        if (token == null || jwtTokenUtil.isTokenExpired(token.substring(7))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }
        User user = userService.getUserByToken(token.substring(7));
        if (user.getRole() != UserRole.ADMIN) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }

        String result = teamService.deleteTeam(id);
        return ResponseEntity.ok(result);
    }
    @PutMapping(path = "/updateTeam")
    public ResponseEntity<Team> updateTeam(@RequestBody Team team,
                                           @RequestHeader(value = "Authorization", required = false) String token) {
        if (token == null || jwtTokenUtil.isTokenExpired(token.substring(7))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        User user = userService.getUserByToken(token.substring(7));
        if (user.getRole() != UserRole.ADMIN) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }

        Team updatedTeam = teamService.updateTeam(team);
        return ResponseEntity.ok(updatedTeam);
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
