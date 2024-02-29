package com.example.WeBKKHustraUhrovec.Service.impl;


import com.example.WeBKKHustraUhrovec.Entity.*;
import com.example.WeBKKHustraUhrovec.Repo.LeagueYearRepo;
import com.example.WeBKKHustraUhrovec.Repo.ResultRepo;
import com.example.WeBKKHustraUhrovec.Repo.TeamRepo;
import com.example.WeBKKHustraUhrovec.Repo.TeamResultRepo;
import com.example.WeBKKHustraUhrovec.Service.TeamResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamResultIMPL implements TeamResultService {

    @Autowired
    private TeamResultRepo teamResultRepo;

    @Autowired
    private TeamRepo teamRepo;

    @Autowired
    private ResultRepo resultRepo;

    @Autowired
    private LeagueYearRepo leagueYearRepo;


    @Override
    public TeamResult addTeamResult(String teamId, String resultId, int score, String matchResult) {
        Team team = teamRepo.findById(Integer.valueOf(teamId)).orElse(null);
        Result result = resultRepo.findById(Integer.valueOf(resultId)).orElse(null);

        TeamResult teamResult = new TeamResult();
        teamResult.setTeam(team);
        teamResult.setScore(score);
        teamResult.setMatchResult(matchResult);
        teamResult.setResult(result);

        return teamResultRepo.save(teamResult);
    }

    @Override
    public long getMatchesPlayed(String teamId, String leagueYearId) {
        Team team = teamRepo.findById(Integer.valueOf(teamId)).orElse(null);
        LeagueYear leagueYear = leagueYearRepo.findById(Integer.valueOf(leagueYearId)).orElse(null);

        if (team != null && leagueYear != null) {
            return teamResultRepo.countByTeamAndResult_LeagueYear(team, leagueYear);
        }
        return 0;
    }

    @Override
    public int getMatchesWon(String teamId, String leagueYearId) {
        Team team = teamRepo.findById(Integer.valueOf(teamId)).orElse(null);
        LeagueYear leagueYear = leagueYearRepo.findById(Integer.valueOf(leagueYearId)).orElse(null);

        if (team != null && leagueYear != null) {
            return teamResultRepo.countByTeamAndMatchResultAndResult_LeagueYear(team, "WIN", leagueYear);
        }
        return 0;
    }

    @Override
    public int getMatchesLost(String teamId, String leagueYearId) {
        Team team = teamRepo.findById(Integer.valueOf(teamId)).orElse(null);
        LeagueYear leagueYear = leagueYearRepo.findById(Integer.valueOf(leagueYearId)).orElse(null);

        if (team != null && leagueYear != null) {
            return teamResultRepo.countByTeamAndMatchResultAndResult_LeagueYear(team, "LOSS", leagueYear);
        }
        return 0;
    }

    @Override
    public int getMatchesDrawn(String teamId, String leagueYearId) {
        Team team = teamRepo.findById(Integer.valueOf(teamId)).orElse(null);
        LeagueYear leagueYear = leagueYearRepo.findById(Integer.valueOf(leagueYearId)).orElse(null);

        if (team != null && leagueYear != null) {
            return teamResultRepo.countByTeamAndMatchResultAndResult_LeagueYear(team, "DRAW", leagueYear);
        }
        return 0;
    }

    @Override
    public double getAverageScore(String teamId, String leagueYearId) {
        Team team = teamRepo.findById(Integer.valueOf(teamId)).orElse(null);
        LeagueYear leagueYear = leagueYearRepo.findById(Integer.valueOf(leagueYearId)).orElse(null);

        if (team != null && leagueYear != null) {
            Double totalScore = teamResultRepo.sumScoreByTeamAndResult_LeagueYear(team, leagueYear);
            Long matchesPlayed = teamResultRepo.countByTeamAndResult_LeagueYear(team, leagueYear);

            if (totalScore != null && matchesPlayed != null && matchesPlayed != 0) {
                return totalScore / matchesPlayed;
            }
        }
        return 0;
    }

    @Override
    public int getPoints(String teamId, String leagueYearId) {
        Team team = teamRepo.findById(Integer.valueOf(teamId)).orElse(null);
        LeagueYear leagueYear = leagueYearRepo.findById(Integer.valueOf(leagueYearId)).orElse(null);

        if (team != null && leagueYear != null) {
            int matchesWon = getMatchesWon(teamId, leagueYearId);
            int matchesDrawn = getMatchesDrawn(teamId, leagueYearId);
            return (matchesWon * 2) + matchesDrawn;
        }
        return 0;
    }

    @Override
    public void deleteTeamResultsByResultId(int resultId) {
        teamResultRepo.deleteByResult_ResultId(resultId);
    }
}
