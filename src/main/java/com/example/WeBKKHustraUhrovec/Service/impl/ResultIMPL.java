package com.example.WeBKKHustraUhrovec.Service.impl;

import com.example.WeBKKHustraUhrovec.Entity.Player;
import com.example.WeBKKHustraUhrovec.Entity.Result;
import com.example.WeBKKHustraUhrovec.Entity.Team;
import com.example.WeBKKHustraUhrovec.Repo.PlayerRepo;
import com.example.WeBKKHustraUhrovec.Repo.ResultRepo;
import com.example.WeBKKHustraUhrovec.Repo.TeamRepo;
import com.example.WeBKKHustraUhrovec.Service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ResultIMPL implements ResultService {

    @Autowired
    private ResultRepo resultRepo;

    @Autowired
    private TeamRepo teamRepo;

    @Autowired
    private PlayerRepo playerRepo;

    @Override
    public Result addResult(String teamIdHome, String teamIdAway, String player1IdHome, String player2IdHome, String player3IdHome, String player4IdHome, String player5IdHome, String player6IdHome, String player1IdAway, String player2IdAway, String player3IdAway, String player4IdAway, String player5IdAway, String player6IdAway, Result result) {
        Team teamHome = teamRepo.findById(Integer.valueOf(teamIdHome)).orElse(null);
        Team teamAway = teamRepo.findById(Integer.valueOf(teamIdAway)).orElse(null);

        Player player1Home = playerRepo.findById(Integer.valueOf(player1IdHome)).orElse(null);
        Player player2Home = playerRepo.findById(Integer.valueOf(player2IdHome)).orElse(null);
        Player player3Home = playerRepo.findById(Integer.valueOf(player3IdHome)).orElse(null);
        Player player4Home = playerRepo.findById(Integer.valueOf(player4IdHome)).orElse(null);
        Player player5Home = playerRepo.findById(Integer.valueOf(player5IdHome)).orElse(null);
        Player player6Home = playerRepo.findById(Integer.valueOf(player6IdHome)).orElse(null);

        Player player1Away = playerRepo.findById(Integer.valueOf(player1IdAway)).orElse(null);
        Player player2Away = playerRepo.findById(Integer.valueOf(player2IdAway)).orElse(null);
        Player player3Away = playerRepo.findById(Integer.valueOf(player3IdAway)).orElse(null);
        Player player4Away = playerRepo.findById(Integer.valueOf(player4IdAway)).orElse(null);
        Player player5Away = playerRepo.findById(Integer.valueOf(player5IdAway)).orElse(null);
        Player player6Away = playerRepo.findById(Integer.valueOf(player6IdAway)).orElse(null);

        result.setTeamHome(teamHome);
        result.setTeamAway(teamAway);

        result.setPlayer1Home(player1Home);
        result.setPlayer2Home(player2Home);
        result.setPlayer3Home(player3Home);
        result.setPlayer4Home(player4Home);
        result.setPlayer5Home(player5Home);
        result.setPlayer6Home(player6Home);

        result.setPlayer1Away(player1Away);
        result.setPlayer2Away(player2Away);
        result.setPlayer3Away(player3Away);
        result.setPlayer4Away(player4Away);
        result.setPlayer5Away(player5Away);
        result.setPlayer6Away(player6Away);

        return resultRepo.save(result);
    }

    public Result addResultSimple(String teamIdHome, String teamIdAway, Result result) {
        Team teamHome = teamRepo.findById(Integer.valueOf(teamIdHome)).orElse(null);
        Team teamAway = teamRepo.findById(Integer.valueOf(teamIdAway)).orElse(null);

        result.setTeamHome(teamHome);
        result.setTeamAway(teamAway);

        return resultRepo.save(result);
    }

    @Override
    public Optional<Result> getResult(String id) {
        return resultRepo.findById(Integer.valueOf(id));
    }

    @Override
    public List<Result> getAllResults() {
        return resultRepo.findAll();
    }

    @Override
    public String deleteResult(Integer id) {
        Result result = resultRepo.findById(id).orElse(null);
        if (result == null) {
            return "Result doesnt exist";
        } else {
            resultRepo.deleteById(id);
            return "Result " + result.getTeamHome().getTeamName() + " - " + result.getTeamAway().getTeamName() + " was deleted";
        }
    }

    @Override
    public Result updateResult(Result result) {
        return null;
    }
}
