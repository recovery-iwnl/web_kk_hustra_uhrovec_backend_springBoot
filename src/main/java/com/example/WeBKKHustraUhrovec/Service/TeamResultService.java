package com.example.WeBKKHustraUhrovec.Service;


import com.example.WeBKKHustraUhrovec.Entity.TeamResult;
import org.springframework.stereotype.Service;

@Service
public interface TeamResultService {

    TeamResult addTeamResult(String teamId, String resultId, int score, String matchResult );
    long getMatchesPlayed(String teamId, String leagueYearId);
    int getMatchesWon(String teamId, String leagueYearId);
    int getMatchesLost(String teamId, String leagueYearId);
    int getMatchesDrawn(String teamId, String leagueYearId);
    double getAverageScore(String teamId, String leagueYearId);
    int getPoints(String teamId, String leagueYearId);
    void deleteTeamResultsByResultId(int resultId);
}
