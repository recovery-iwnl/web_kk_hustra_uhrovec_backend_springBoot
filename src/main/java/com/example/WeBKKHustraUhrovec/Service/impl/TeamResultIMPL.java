package com.example.WeBKKHustraUhrovec.Service.impl;


import com.example.WeBKKHustraUhrovec.Entity.Player;
import com.example.WeBKKHustraUhrovec.Entity.Result;
import com.example.WeBKKHustraUhrovec.Entity.Team;
import com.example.WeBKKHustraUhrovec.Entity.TeamResult;
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
    public long getMatchesPlayed(String teamId) {
        Team team = teamRepo.findById(Integer.valueOf(teamId)).orElse(null);
        if (team != null) {
            return teamResultRepo.countByTeam(team);
        }
        return 0;
    }

    @Override
    public int getMatchesWon(String teamId) {
        Team team = teamRepo.findById(Integer.valueOf(teamId)).orElse(null);
        if (team != null) {
            return teamResultRepo.countByTeamAndMatchResult(team, "WIN");
        }
        return 0;
    }

    @Override
    public int getMatchesLost(String teamId) {
        Team team = teamRepo.findById(Integer.valueOf(teamId)).orElse(null);
        if (team != null) {
            return teamResultRepo.countByTeamAndMatchResult(team, "LOSS");
        }
        return 0;
    }

    @Override
    public int getMatchesDrawn(String teamId) {
        Team team = teamRepo.findById(Integer.valueOf(teamId)).orElse(null);
        if (team != null) {
            return teamResultRepo.countByTeamAndMatchResult(team, "DRAW");
        }
        return 0;
    }

    @Override
    public double getAverageScore(String teamId) {
        Team team = teamRepo.findById(Integer.valueOf(teamId)).orElse(null);
        if (team != null) {

            Double totalScore = teamResultRepo.sumScoreByTeam(team);
            Long matchesPlayed = teamResultRepo.countByTeam(team);

            if (totalScore != null && matchesPlayed != null && matchesPlayed != 0) {
                return totalScore / matchesPlayed;
            }
        }
        return 0;
    }

    @Override
    public int getPoints(String teamId) {
        Team team = teamRepo.findById(Integer.valueOf(teamId)).orElse(null);
        if (team != null) {
            int matchesWon = getMatchesWon(teamId);
            int matchesDrawn = getMatchesDrawn(teamId);
            return (matchesWon * 2) + matchesDrawn;
        }
        return 0;
    }

    @Override
    public void deleteTeamResultsByResultId(int resultId) {
        teamResultRepo.deleteByResult_ResultId(resultId);
    }
}
