package com.example.WeBKKHustraUhrovec.Service;

import com.example.WeBKKHustraUhrovec.Entity.Player;
import com.example.WeBKKHustraUhrovec.Entity.Team;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface TeamService {

    Team addTeam(Team  Team);

    Optional<Team> getTeam(String id);

    List<Team> getAllTeams();

    String deleteTeam(Integer id);

    Team updateTeam(Team team);

    List<Player> getPlayers(String id);
}
