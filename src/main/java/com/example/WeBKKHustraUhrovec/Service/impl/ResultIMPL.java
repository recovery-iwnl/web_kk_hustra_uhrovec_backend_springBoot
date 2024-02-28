package com.example.WeBKKHustraUhrovec.Service.impl;

import com.example.WeBKKHustraUhrovec.Entity.Player;
import com.example.WeBKKHustraUhrovec.Entity.Result;
import com.example.WeBKKHustraUhrovec.Entity.Team;
import com.example.WeBKKHustraUhrovec.Entity.TeamResult;
import com.example.WeBKKHustraUhrovec.Repo.PlayerRepo;
import com.example.WeBKKHustraUhrovec.Repo.ResultRepo;
import com.example.WeBKKHustraUhrovec.Repo.TeamRepo;
import com.example.WeBKKHustraUhrovec.Repo.TeamResultRepo;
import com.example.WeBKKHustraUhrovec.Service.PlayerResultService;
import com.example.WeBKKHustraUhrovec.Service.ResultService;
import com.example.WeBKKHustraUhrovec.Service.TeamResultService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private TeamResultRepo teamResultRepo;

    @Autowired
    private TeamResultService teamResultService;

    @Autowired
    private PlayerResultService playerResultService;

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

    @Override
    public Result addResultSimple(String teamIdHome, String teamIdAway, Result result) {
        Team teamHome = teamRepo.findById(Integer.valueOf(teamIdHome)).orElse(null);
        Team teamAway = teamRepo.findById(Integer.valueOf(teamIdAway)).orElse(null);

        result.setTeamHome(teamHome);
        result.setTeamAway(teamAway);

        resultRepo.save(result);

        if(result.getTeam1PointsOverall() > result.getTeam2PointsOverall()) {
            // Home Team Won
            teamResultService.addTeamResult(teamIdHome, String.valueOf(result.getResultId()), result.getTeam1ScoreOverall(),"WIN");
            teamResultService.addTeamResult(teamIdAway, String.valueOf(result.getResultId()),result.getTeam2ScoreOverall(),"LOSS");

        } else if (result.getTeam1PointsOverall() < result.getTeam2PointsOverall()) {
            // Away Team Won
            teamResultService.addTeamResult(teamIdAway, String.valueOf(result.getResultId()),result.getTeam2ScoreOverall(),"WIN");
            teamResultService.addTeamResult(teamIdHome, String.valueOf(result.getResultId()),result.getTeam1ScoreOverall(),"LOSS");
        } else {
            // Draw
            teamResultService.addTeamResult(teamIdHome, String.valueOf(result.getResultId()),result.getTeam1ScoreOverall(),"DRAW");
            teamResultService.addTeamResult(teamIdAway, String.valueOf(result.getResultId()),result.getTeam2ScoreOverall(),"DRAW");
        }

        for (int i = 1; i <= 6; i++) {
            int playerScoreHome = getPlayerScoreHome(result, i);
            int playerScoreAway = getPlayerScoreAway(result, i);
            String playerHomeId = getPlayerIdHome(result, i);
            String playerAwayId = getPlayerIdAway(result, i);

            if (playerScoreHome > playerScoreAway) {
                // Home Player Won
                playerResultService.addPlayerResult(playerHomeId, String.valueOf(result.getResultId()), playerScoreHome, "WIN");
                playerResultService.addPlayerResult(playerAwayId, String.valueOf(result.getResultId()), playerScoreHome, "LOSS");
            } else if (playerScoreHome < playerScoreAway) {
                // Away player Won
                playerResultService.addPlayerResult(playerHomeId, String.valueOf(result.getResultId()), playerScoreHome, "LOSS");
                playerResultService.addPlayerResult(playerAwayId, String.valueOf(result.getResultId()), playerScoreHome, "WIN");
            } else {
                // Draw
                playerResultService.addPlayerResult(playerHomeId, String.valueOf(result.getResultId()), playerScoreHome, "DRAW");
                playerResultService.addPlayerResult(playerAwayId, String.valueOf(result.getResultId()), playerScoreHome, "DRAW");
            }
        }

        return resultRepo.save(result);
    }

    private int getPlayerScoreHome(Result result, int playerNumber) {
        return switch (playerNumber) {
            case 1 -> result.getPlayer1ScoreHome();
            case 2 -> result.getPlayer2ScoreHome();
            case 3 -> result.getPlayer3ScoreHome();
            case 4 -> result.getPlayer4ScoreHome();
            case 5 -> result.getPlayer5ScoreHome();
            case 6 -> result.getPlayer6ScoreHome();
            default -> 0;
        };
    }
    private int getPlayerScoreAway(Result result, int playerNumber) {
        return switch (playerNumber) {
            case 1 -> result.getPlayer1ScoreAway();
            case 2 -> result.getPlayer2ScoreAway();
            case 3 -> result.getPlayer3ScoreAway();
            case 4 -> result.getPlayer4ScoreAway();
            case 5 -> result.getPlayer5ScoreAway();
            case 6 -> result.getPlayer6ScoreAway();
            default -> 0;
        };
    }
    private String getPlayerIdHome(Result result, int playerNumber) {
        return switch (playerNumber) {
            case 1 -> String.valueOf(result.getPlayer1Home().getPlayerID());
            case 2 -> String.valueOf(result.getPlayer2Home().getPlayerID());
            case 3 -> String.valueOf(result.getPlayer3Home().getPlayerID());
            case 4 -> String.valueOf(result.getPlayer4Home().getPlayerID());
            case 5 -> String.valueOf(result.getPlayer5Home().getPlayerID());
            case 6 -> String.valueOf(result.getPlayer6Home().getPlayerID());
            default -> null;
        };
    }

    private String getPlayerIdAway(Result result, int playerNumber) {
        return switch (playerNumber) {
            case 1 -> String.valueOf(result.getPlayer1Away().getPlayerID());
            case 2 -> String.valueOf(result.getPlayer2Away().getPlayerID());
            case 3 -> String.valueOf(result.getPlayer3Away().getPlayerID());
            case 4 -> String.valueOf(result.getPlayer4Away().getPlayerID());
            case 5 -> String.valueOf(result.getPlayer5Away().getPlayerID());
            case 6 -> String.valueOf(result.getPlayer6Away().getPlayerID());
            default -> null;
        };
    }

    @Override
    public Optional<Result> getResult(String id) {
        return resultRepo.findById(Integer.valueOf(id));
    }

    @Override
    public List<Result> getAllResults() {
        return resultRepo.findAllByOrderByDateDesc();
    }

    @Override
    public List<Result> getResultsUhrovec() {
        List<Result> results = resultRepo.findAllByOrderByDateDesc();
        List<Result> filtered = new ArrayList<>();

        for (Result r: results) {
            if (r.getTeamAway().getTeamName().equals("KK Hustra Uhrovec") || r.getTeamHome().getTeamName().equals("KK Hustra Uhrovec")) {
                filtered.add(r);
            }
        }
        return filtered;
    }

    @Override
    @Transactional
    public String deleteResult(Integer id) {
        Result result = resultRepo.findById(id).orElse(null);
        if (result == null) {
            return "Result doesnt exist";
        } else {
            teamResultService.deleteTeamResultsByResultId(result.getResultId());
            playerResultService.deletePlayerResultsByResultId(result.getResultId());
            resultRepo.deleteById(id);
            return "Result " + result.getTeamHome().getTeamName() + " - " + result.getTeamAway().getTeamName() + " was deleted";
        }
    }
}
