package com.example.WeBKKHustraUhrovec.Service.impl;

import com.example.WeBKKHustraUhrovec.Entity.LeagueYear;
import com.example.WeBKKHustraUhrovec.Entity.Player;
import com.example.WeBKKHustraUhrovec.Entity.PlayerResult;
import com.example.WeBKKHustraUhrovec.Entity.Result;
import com.example.WeBKKHustraUhrovec.Repo.*;
import com.example.WeBKKHustraUhrovec.Service.PlayerResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerResultIMPL implements PlayerResultService {
    @Autowired
    private PlayerResultRepo playerResultRepo;

    @Autowired
    private PlayerRepo playerRepo;

    @Autowired
    private ResultRepo resultRepo;

    @Autowired
    private LeagueYearRepo leagueYearRepo;


    @Override
    public PlayerResult addPlayerResult(String playerId, String resultId, int score, String matchResult) {
        Player player = playerRepo.findById(Integer.valueOf(playerId)).orElse(null);
        Result result = resultRepo.findById(Integer.valueOf(resultId)).orElse(null);

        PlayerResult pR = new PlayerResult();
        pR.setPlayer(player);
        pR.setScore(score);
        pR.setResult(result);
        pR.setMatchResult(matchResult);

        return playerResultRepo.save(pR);
    }

    @Override
    public long getMatchesPlayed(String playerId, String leagueYearId) {
        Player player = playerRepo.findById(Integer.valueOf(playerId)).orElse(null);
        LeagueYear leagueYear = leagueYearRepo.findById(Integer.valueOf(leagueYearId)).orElse(null);
        if (player != null && leagueYear != null) {
            return playerResultRepo.countByPlayerAndResult_LeagueYear(player, leagueYear);
        }
        return 0;
    }

    @Override
    public long getMatchesWon(String playerId, String leagueYearId) {
        Player player = playerRepo.findById(Integer.valueOf(playerId)).orElse(null);
        LeagueYear leagueYear = leagueYearRepo.findById(Integer.valueOf(leagueYearId)).orElse(null);
        if (player != null && leagueYear != null) {
            return playerResultRepo.countByPlayerAndMatchResultAndResult_LeagueYear(player, "WIN",leagueYear);
        }
        return 0;
    }

    @Override
    public long getMatchesDrawn(String playerId, String leagueYearId) {
        Player player = playerRepo.findById(Integer.valueOf(playerId)).orElse(null);
        LeagueYear leagueYear = leagueYearRepo.findById(Integer.valueOf(leagueYearId)).orElse(null);
        if (player != null && leagueYear != null) {
            return playerResultRepo.countByPlayerAndMatchResultAndResult_LeagueYear(player, "DRAW",leagueYear);
        }
        return 0;
    }

    @Override
    public long getMatchesLost(String playerId, String leagueYearId) {
        Player player = playerRepo.findById(Integer.valueOf(playerId)).orElse(null);
        LeagueYear leagueYear = leagueYearRepo.findById(Integer.valueOf(leagueYearId)).orElse(null);
        if (player != null && leagueYear != null) {
            return playerResultRepo.countByPlayerAndMatchResultAndResult_LeagueYear(player, "LOSS",leagueYear);
        }
        return 0;
    }

    @Override
    public double getAverageScore(String playerId, String leagueYearId) {
        Player player = playerRepo.findById(Integer.valueOf(playerId)).orElse(null);
        LeagueYear leagueYear = leagueYearRepo.findById(Integer.valueOf(leagueYearId)).orElse(null);

        if (player != null && leagueYear != null) {
            Double totalScore = playerResultRepo.sumScoreByPlayerAndResult_LeagueYear(player, leagueYear);;
            Long matchesPlayed = playerResultRepo.countByPlayerAndResult_LeagueYear(player, leagueYear);;

            if (totalScore != null && matchesPlayed != null && matchesPlayed != 0) {
                return totalScore / matchesPlayed;
            }
        }
        return 0;
    }

    @Override
    public int getPlayersBest(String playerId, String leagueYearId) {
        Player player = playerRepo.findById(Integer.valueOf(playerId)).orElse(null);
        LeagueYear leagueYear = leagueYearRepo.findById(Integer.valueOf(leagueYearId)).orElse(null);

        if (player != null && leagueYear != null) {
            Integer maxScore = playerResultRepo.findMaxScoreByPlayerAndResult_LeagueYear(player, leagueYear);
            return maxScore != null ? maxScore : 0;
        }
        return 0;
    }

    @Override
    public int getPlayersWorst(String playerId, String leagueYearId) {
        Player player = playerRepo.findById(Integer.valueOf(playerId)).orElse(null);
        LeagueYear leagueYear = leagueYearRepo.findById(Integer.valueOf(leagueYearId)).orElse(null);

        if (player != null && leagueYear != null) {
            Integer minScore = playerResultRepo.findMinScoreByPlayerAndResult_LeagueYear(player, leagueYear);
            return minScore != null ? minScore : 0;
        }
        return 0;
    }

    @Override
    public void deletePlayerResultsByResultId(int resultId) {
        playerResultRepo.deleteByResult_ResultId(resultId);
    }
}
