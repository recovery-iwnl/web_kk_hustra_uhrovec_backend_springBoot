package com.example.WeBKKHustraUhrovec.Service;

import com.example.WeBKKHustraUhrovec.Entity.PlayerResult;
import com.example.WeBKKHustraUhrovec.Entity.TeamResult;
import org.springframework.stereotype.Service;

@Service
public interface PlayerResultService {
    PlayerResult addPlayerResult(String playerId, String resultId, int score, String matchResult );

    long getMatchesPlayed(String playerId);

    double getAverageScore(String playerId);

    int getPlayersBest(String playerId);

    void deletePlayerResultsByResultId(int resultId);
}
