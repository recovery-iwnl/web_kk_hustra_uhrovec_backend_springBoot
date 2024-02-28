package com.example.WeBKKHustraUhrovec.Service.impl;

import com.example.WeBKKHustraUhrovec.Entity.*;
import com.example.WeBKKHustraUhrovec.Repo.*;
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

    @Autowired
    private LeagueYearRepo leagueYearRepo;

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
            double playerPointsHome = getPlayerPointsHome(result, i);
            double playerPointsAway = getPlayerPointsAway(result, i);
            String playerHomeId = getPlayerIdHome(result, i);
            String playerAwayId = getPlayerIdAway(result, i);

            if (playerPointsHome > playerPointsAway) {
                // Home Player Won
                playerResultService.addPlayerResult(playerHomeId, String.valueOf(result.getResultId()), playerScoreHome, "WIN");
                playerResultService.addPlayerResult(playerAwayId, String.valueOf(result.getResultId()), playerScoreAway, "LOSS");
            } else if (playerPointsHome < playerPointsAway) {
                // Away player Won
                playerResultService.addPlayerResult(playerHomeId, String.valueOf(result.getResultId()), playerScoreHome, "LOSS");
                playerResultService.addPlayerResult(playerAwayId, String.valueOf(result.getResultId()), playerScoreAway, "WIN");
            } else {
                // Draw
                playerResultService.addPlayerResult(playerHomeId, String.valueOf(result.getResultId()), playerScoreHome, "DRAW");
                playerResultService.addPlayerResult(playerAwayId, String.valueOf(result.getResultId()), playerScoreAway, "DRAW");
            }
        }

        return resultRepo.save(result);
    }

    private double getPlayerPointsHome(Result result, int playerNumber) {
        return switch (playerNumber) {
            case 1 -> result.getPlayer1PointsHome();
            case 2 -> result.getPlayer2PointsHome();
            case 3 -> result.getPlayer3PointsHome();
            case 4 -> result.getPlayer4PointsHome();
            case 5 -> result.getPlayer5PointsHome();
            case 6 -> result.getPlayer6PointsHome();
            default -> 0;
        };
    }

    private double getPlayerPointsAway(Result result, int playerNumber) {
        return switch (playerNumber) {
            case 1 -> result.getPlayer1PointsAway();
            case 2 -> result.getPlayer2PointsAway();
            case 3 -> result.getPlayer3PointsAway();
            case 4 -> result.getPlayer4PointsAway();
            case 5 -> result.getPlayer5PointsAway();
            case 6 -> result.getPlayer6PointsAway();
            default -> 0;
        };
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
    public List<Result> getResultsByLeagueYear(String id) {
        LeagueYear leagueYear = leagueYearRepo.findById(Integer.valueOf(id)).orElse(null);
        return resultRepo.findAllByLeagueYearOrderByDateDesc(leagueYear);
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
