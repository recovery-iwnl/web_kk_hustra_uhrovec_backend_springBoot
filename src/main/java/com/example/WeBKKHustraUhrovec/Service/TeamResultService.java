package com.example.WeBKKHustraUhrovec.Service;

import com.example.WeBKKHustraUhrovec.Entity.TeamResult;
import org.springframework.stereotype.Service;

@Service
public interface TeamResultService {

    TeamResult addTeamResult(String teamId, String resultId, int score, String matchResult );
    long getMatchesPlayed(String teamId);
    int getMatchesWon(String teamId);
    int getMatchesLost(String teamId);
    int getMatchesDrawn(String teamId);
    double getAverageScore(String teamId);
    int getPoints(String teamId);
    void deleteTeamResultsByResultId(int resultId);
}
