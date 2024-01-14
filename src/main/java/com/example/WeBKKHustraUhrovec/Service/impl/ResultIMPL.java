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

        if(result.getTeam1PointsOverall() > result.getTeam2PointsOverall()) {
            // Home Team Won
            // Home Team add points
            result.getTeamHome().setPoints(result.getTeamHome().getPoints()+2);
            result.getTeamHome().setMatchesWon(result.getTeamHome().getMatchesWon()+1);

            result.getTeamAway().setMatchesLost(result.getTeamAway().getMatchesLost()+1);

        } else if (result.getTeam1PointsOverall() < result.getTeam2PointsOverall()) {
            // Away Team Won
            // Away Team add points
            result.getTeamAway().setPoints(result.getTeamAway().getPoints()+2);
            result.getTeamAway().setMatchesWon(result.getTeamAway().getMatchesWon()+1);

            result.getTeamHome().setMatchesLost(result.getTeamHome().getMatchesLost()+1);

        } else {
            // Draw
            // Home Team add points
            result.getTeamHome().setPoints(result.getTeamHome().getPoints()+1);
            result.getTeamHome().setMatchesDraw(result.getTeamHome().getMatchesDraw()+1);
            // Away Team add points
            result.getTeamAway().setPoints(result.getTeamAway().getPoints()+1);
            result.getTeamAway().setMatchesDraw(result.getTeamAway().getMatchesDraw()+1);
        }

        // Home Team add stat - Matches Played | AverageThrownFrames
        result.getTeamHome().setMatchesPlayed(result.getTeamHome().getMatchesPlayed()+1);
        result.getTeamHome().setThrownFrames(result.getTeamHome().getThrownFrames() + result.getTeam1ScoreOverall());
        // Home Players add MatchesPlayed
        result.getPlayer1Home().setMatchesPlayed(result.getPlayer1Home().getMatchesPlayed()+1);
        result.getPlayer2Home().setMatchesPlayed(result.getPlayer2Home().getMatchesPlayed()+1);
        result.getPlayer3Home().setMatchesPlayed(result.getPlayer3Home().getMatchesPlayed()+1);
        result.getPlayer4Home().setMatchesPlayed(result.getPlayer4Home().getMatchesPlayed()+1);
        result.getPlayer5Home().setMatchesPlayed(result.getPlayer5Home().getMatchesPlayed()+1);
        result.getPlayer6Home().setMatchesPlayed(result.getPlayer6Home().getMatchesPlayed()+1);
        // Home Players add Score
        result.getPlayer1Home().setPoints(result.getPlayer1Home().getPoints()+result.getPlayer1ScoreHome());
        result.getPlayer2Home().setPoints(result.getPlayer2Home().getPoints()+result.getPlayer2ScoreHome());
        result.getPlayer3Home().setPoints(result.getPlayer3Home().getPoints()+result.getPlayer3ScoreHome());
        result.getPlayer4Home().setPoints(result.getPlayer4Home().getPoints()+result.getPlayer4ScoreHome());
        result.getPlayer5Home().setPoints(result.getPlayer5Home().getPoints()+result.getPlayer5ScoreHome());
        result.getPlayer6Home().setPoints(result.getPlayer6Home().getPoints()+result.getPlayer6ScoreHome());
        // Home Players add PlayersBest
        if(result.getPlayer1ScoreHome() > result.getPlayer1Home().getPlayersBest()) {
            result.getPlayer1Home().setPlayersBest(result.getPlayer1ScoreHome());
        }
        if(result.getPlayer2ScoreHome() > result.getPlayer2Home().getPlayersBest()) {
            result.getPlayer2Home().setPlayersBest(result.getPlayer2ScoreHome());
        }
        if(result.getPlayer3ScoreHome() > result.getPlayer3Home().getPlayersBest()) {
            result.getPlayer3Home().setPlayersBest(result.getPlayer3ScoreHome());
        }
        if(result.getPlayer4ScoreHome() > result.getPlayer4Home().getPlayersBest()) {
            result.getPlayer4Home().setPlayersBest(result.getPlayer4ScoreHome());
        }
        if(result.getPlayer5ScoreHome() > result.getPlayer5Home().getPlayersBest()) {
            result.getPlayer5Home().setPlayersBest(result.getPlayer5ScoreHome());
        }
        if(result.getPlayer6ScoreHome() > result.getPlayer6Home().getPlayersBest()) {
            result.getPlayer6Home().setPlayersBest(result.getPlayer6ScoreHome());
        }

        updatePlayersHome(result);


        // Away Team add stat - Matches Played | AverageThrownFrames
        result.getTeamAway().setMatchesPlayed(result.getTeamAway().getMatchesPlayed()+1);
        result.getTeamAway().setThrownFrames(result.getTeamAway().getThrownFrames() + result.getTeam2ScoreOverall());
        // Away Players add MatchesPlayed
        result.getPlayer1Away().setMatchesPlayed(result.getPlayer1Away().getMatchesPlayed()+1);
        result.getPlayer2Away().setMatchesPlayed(result.getPlayer2Away().getMatchesPlayed()+1);
        result.getPlayer3Away().setMatchesPlayed(result.getPlayer3Away().getMatchesPlayed()+1);
        result.getPlayer4Away().setMatchesPlayed(result.getPlayer4Away().getMatchesPlayed()+1);
        result.getPlayer5Away().setMatchesPlayed(result.getPlayer5Away().getMatchesPlayed()+1);
        result.getPlayer6Away().setMatchesPlayed(result.getPlayer6Away().getMatchesPlayed()+1);
        // Away Players add Score
        result.getPlayer1Away().setPoints(result.getPlayer1Away().getPoints()+result.getPlayer1ScoreAway());
        result.getPlayer2Away().setPoints(result.getPlayer2Away().getPoints()+result.getPlayer2ScoreAway());
        result.getPlayer3Away().setPoints(result.getPlayer3Away().getPoints()+result.getPlayer3ScoreAway());
        result.getPlayer4Away().setPoints(result.getPlayer4Away().getPoints()+result.getPlayer4ScoreAway());
        result.getPlayer5Away().setPoints(result.getPlayer5Away().getPoints()+result.getPlayer5ScoreAway());
        result.getPlayer6Away().setPoints(result.getPlayer6Away().getPoints()+result.getPlayer6ScoreAway());
        // Away Players add PlayersBest
        if(result.getPlayer1ScoreAway() > result.getPlayer1Away().getPlayersBest()) {
            result.getPlayer1Away().setPlayersBest(result.getPlayer1ScoreAway());
        }
        if(result.getPlayer2ScoreAway() > result.getPlayer2Away().getPlayersBest()) {
            result.getPlayer2Away().setPlayersBest(result.getPlayer2ScoreAway());
        }
        if(result.getPlayer3ScoreAway() > result.getPlayer3Away().getPlayersBest()) {
            result.getPlayer3Away().setPlayersBest(result.getPlayer3ScoreAway());
        }
        if(result.getPlayer4ScoreAway() > result.getPlayer4Away().getPlayersBest()) {
            result.getPlayer4Away().setPlayersBest(result.getPlayer4ScoreAway());
        }
        if(result.getPlayer5ScoreAway() > result.getPlayer5Away().getPlayersBest()) {
            result.getPlayer5Away().setPlayersBest(result.getPlayer5ScoreAway());
        }
        if(result.getPlayer6ScoreAway() > result.getPlayer6Away().getPlayersBest()) {
            result.getPlayer6Away().setPlayersBest(result.getPlayer6ScoreAway());
        }


        updatePlayersAway(result);

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
    public List<Result> getResultsUhrovec() {
        List<Result> results = resultRepo.findAll();
        List<Result> filtered = new ArrayList<>();

        for (Result r: results) {
            if (r.getTeamAway().getTeamName().equals("KK Hustra Uhrovec") || r.getTeamHome().getTeamName().equals("KK Hustra Uhrovec")) {
                filtered.add(r);
            }
        }
        return filtered;
    }

    @Override
    public String deleteResult(Integer id) {
        Result result = resultRepo.findById(id).orElse(null);
        if (result == null) {
            return "Result doesnt exist";
        } else {
            if(result.getTeam1PointsOverall() > result.getTeam2PointsOverall()) {
                // Home Team Won
                // Home Team fix points
                result.getTeamHome().setPoints(result.getTeamHome().getPoints()-2);
                result.getTeamHome().setMatchesWon(result.getTeamHome().getMatchesWon()-1);

                result.getTeamAway().setMatchesLost(result.getTeamAway().getMatchesLost()-1);

            } else if (result.getTeam1PointsOverall() < result.getTeam2PointsOverall()) {
                // Away Team Won
                // Away Team fix points
                result.getTeamAway().setPoints(result.getTeamAway().getPoints()-2);
                result.getTeamAway().setMatchesWon(result.getTeamAway().getMatchesWon()-1);

                result.getTeamHome().setMatchesLost(result.getTeamHome().getMatchesLost()-1);

            } else {
                // Draw
                // Home Team fix points
                result.getTeamHome().setPoints(result.getTeamHome().getPoints()-1);
                result.getTeamHome().setMatchesDraw(result.getTeamHome().getMatchesDraw()-1);
                // Away Team fix points
                result.getTeamAway().setPoints(result.getTeamAway().getPoints()-1);
                result.getTeamAway().setMatchesDraw(result.getTeamAway().getMatchesDraw()-1);
            }

            // Home Team add stat - Matches Played | AverageThrownFrames
            result.getTeamHome().setMatchesPlayed(result.getTeamHome().getMatchesPlayed()-1);
            result.getTeamHome().setThrownFrames(result.getTeamHome().getThrownFrames() - result.getTeam1ScoreOverall());
            // Home Players fix MatchesPlayed
            result.getPlayer1Home().setMatchesPlayed(result.getPlayer1Home().getMatchesPlayed()-1);
            result.getPlayer2Home().setMatchesPlayed(result.getPlayer2Home().getMatchesPlayed()-1);
            result.getPlayer3Home().setMatchesPlayed(result.getPlayer3Home().getMatchesPlayed()-1);
            result.getPlayer4Home().setMatchesPlayed(result.getPlayer4Home().getMatchesPlayed()-1);
            result.getPlayer5Home().setMatchesPlayed(result.getPlayer5Home().getMatchesPlayed()-1);
            result.getPlayer6Home().setMatchesPlayed(result.getPlayer6Home().getMatchesPlayed()-1);
            // Home Players fix Score
            result.getPlayer1Home().setPoints(result.getPlayer1Home().getPoints()-result.getPlayer1ScoreHome());
            result.getPlayer2Home().setPoints(result.getPlayer2Home().getPoints()-result.getPlayer2ScoreHome());
            result.getPlayer3Home().setPoints(result.getPlayer3Home().getPoints()-result.getPlayer3ScoreHome());
            result.getPlayer4Home().setPoints(result.getPlayer4Home().getPoints()-result.getPlayer4ScoreHome());
            result.getPlayer5Home().setPoints(result.getPlayer5Home().getPoints()-result.getPlayer5ScoreHome());
            result.getPlayer6Home().setPoints(result.getPlayer6Home().getPoints()-result.getPlayer6ScoreHome());
            // Home Players fix PlayersBest
            /*result.getPlayer1Home().setPlayersBest(result.getPlayer1Home().getPlayersBest());
            result.getPlayer2Home().setPlayersBest(result.getPlayer1Home().getPlayersBest());
            result.getPlayer3Home().setPlayersBest(result.getPlayer1Home().getPlayersBest());
            result.getPlayer4Home().setPlayersBest(result.getPlayer1Home().getPlayersBest());
            result.getPlayer5Home().setPlayersBest(result.getPlayer1Home().getPlayersBest());
            result.getPlayer6Home().setPlayersBest(result.getPlayer1Home().getPlayersBest());*/

            updatePlayersHome(result);


            // Away Team add stat - Matches Played | AverageThrownFrames
            result.getTeamAway().setMatchesPlayed(result.getTeamAway().getMatchesPlayed()-1);
            result.getTeamAway().setThrownFrames(result.getTeamAway().getThrownFrames() - result.getTeam2ScoreOverall());
            // Away Players fix MatchesPlayed
            result.getPlayer1Away().setMatchesPlayed(result.getPlayer1Away().getMatchesPlayed()-1);
            result.getPlayer2Away().setMatchesPlayed(result.getPlayer2Away().getMatchesPlayed()-1);
            result.getPlayer3Away().setMatchesPlayed(result.getPlayer3Away().getMatchesPlayed()-1);
            result.getPlayer4Away().setMatchesPlayed(result.getPlayer4Away().getMatchesPlayed()-1);
            result.getPlayer5Away().setMatchesPlayed(result.getPlayer5Away().getMatchesPlayed()-1);
            result.getPlayer6Away().setMatchesPlayed(result.getPlayer6Away().getMatchesPlayed()-1);
            // Away Players fix Score
            result.getPlayer1Away().setPoints(result.getPlayer1Away().getPoints()-result.getPlayer1ScoreAway());
            result.getPlayer2Away().setPoints(result.getPlayer2Away().getPoints()-result.getPlayer2ScoreAway());
            result.getPlayer3Away().setPoints(result.getPlayer3Away().getPoints()-result.getPlayer3ScoreAway());
            result.getPlayer4Away().setPoints(result.getPlayer4Away().getPoints()-result.getPlayer4ScoreAway());
            result.getPlayer5Away().setPoints(result.getPlayer5Away().getPoints()-result.getPlayer5ScoreAway());
            result.getPlayer6Away().setPoints(result.getPlayer6Away().getPoints()-result.getPlayer6ScoreAway());
            // Away Players fix PlayersBest
            /*result.getPlayer1Away().setPlayersBest(...);
            result.getPlayer2Away().setPlayersBest(...);
            result.getPlayer3Away().setPlayersBest(...);
            result.getPlayer4Away().setPlayersBest(...);
            result.getPlayer5Away().setPlayersBest(...);
            result.getPlayer6Away().setPlayersBest(...);*/

            updatePlayersAway(result);

            resultRepo.deleteById(id);
            return "Result " + result.getTeamHome().getTeamName() + " - " + result.getTeamAway().getTeamName() + " was deleted";
        }
    }

    private void updatePlayersAway(Result result) {
        Team teamA = teamRepo.findById(result.getTeamAway().getTeamId()).orElse(null);
        result.getPlayer1Away().setTeam(teamA);
        result.getPlayer2Away().setTeam(teamA);
        result.getPlayer3Away().setTeam(teamA);
        result.getPlayer4Away().setTeam(teamA);
        result.getPlayer5Away().setTeam(teamA);
        result.getPlayer6Away().setTeam(teamA);
        playerRepo.save(result.getPlayer1Away());
        playerRepo.save(result.getPlayer2Away());
        playerRepo.save(result.getPlayer3Away());
        playerRepo.save(result.getPlayer4Away());
        playerRepo.save(result.getPlayer5Away());
        playerRepo.save(result.getPlayer6Away());
    }

    private void updatePlayersHome(Result result) {
        Team teamH = teamRepo.findById(result.getTeamHome().getTeamId()).orElse(null);
        result.getPlayer1Home().setTeam(teamH);
        result.getPlayer2Home().setTeam(teamH);
        result.getPlayer3Home().setTeam(teamH);
        result.getPlayer4Home().setTeam(teamH);
        result.getPlayer5Home().setTeam(teamH);
        result.getPlayer6Home().setTeam(teamH);
        playerRepo.save(result.getPlayer1Home());
        playerRepo.save(result.getPlayer2Home());
        playerRepo.save(result.getPlayer3Home());
        playerRepo.save(result.getPlayer4Home());
        playerRepo.save(result.getPlayer5Home());
        playerRepo.save(result.getPlayer6Home());
    }

    @Override
    public Result updateResult(Result result) {
        return null;
    }
}
