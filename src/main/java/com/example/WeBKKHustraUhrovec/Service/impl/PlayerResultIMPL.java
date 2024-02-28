package com.example.WeBKKHustraUhrovec.Service.impl;

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
    public long getMatchesPlayed(String playerId) {
        Player player = playerRepo.findById(Integer.valueOf(playerId)).orElse(null);
        if (player != null) {
            return playerResultRepo.countByPlayer(player);
        }
        return 0;
    }

    @Override
    public double getAverageScore(String playerId) {
        Player player = playerRepo.findById(Integer.valueOf(playerId)).orElse(null);
        if (player != null) {
            Double totalScore = playerResultRepo.sumScoreByPlayer(player);
            Long matchesPlayed = playerResultRepo.countByPlayer(player);

            if (totalScore != null && matchesPlayed != null && matchesPlayed != 0) {
                return totalScore / matchesPlayed;
            }
        }
        return 0;
    }

    @Override
    public int getPlayersBest(String playerId) {
        Player player = playerRepo.findById(Integer.valueOf(playerId)).orElse(null);
        if (player != null) {
            Integer maxScore = playerResultRepo.findMaxScoreByPlayer(player);
            return maxScore != null ? maxScore : 0;
        }
        return 0;
    }

    @Override
    public void deletePlayerResultsByResultId(int resultId) {
        playerResultRepo.deleteByResult_ResultId(resultId);
    }
}
