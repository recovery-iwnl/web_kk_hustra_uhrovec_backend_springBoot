package com.example.WeBKKHustraUhrovec.Service.impl;


import com.example.WeBKKHustraUhrovec.Entity.Result;
import com.example.WeBKKHustraUhrovec.Entity.Team;
import com.example.WeBKKHustraUhrovec.Entity.UpcomingMatch;
import com.example.WeBKKHustraUhrovec.Repo.TeamRepo;
import com.example.WeBKKHustraUhrovec.Repo.UpcomingMatchRepo;
import com.example.WeBKKHustraUhrovec.Service.UpcomingMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UpcomingMatchIMPL implements UpcomingMatchService {

    @Autowired
    private TeamRepo teamRepo;

    @Autowired
    private UpcomingMatchRepo upcomingMatchRepo;

    @Override
    public UpcomingMatch addMatch(String teamIdHome, String teamIdAway, UpcomingMatch upcomingMatch) {
        Team teamHome = teamRepo.findById(Integer.valueOf(teamIdHome)).orElse(null);
        Team teamAway = teamRepo.findById(Integer.valueOf(teamIdAway)).orElse(null);


        upcomingMatch.setTeamHome(teamHome);
        upcomingMatch.setTeamAway(teamAway);

        return upcomingMatchRepo.save(upcomingMatch);
    }

    @Override
    public List<UpcomingMatch> getAllMatches() {
        return upcomingMatchRepo.findAllByOrderByDateAsc();
    }

    @Override
    public List<UpcomingMatch> getMatchesUhrovec() {
        List<UpcomingMatch> matches = upcomingMatchRepo.findAllByOrderByDateAsc();
        List<UpcomingMatch> filtered = new ArrayList<>();

        for (UpcomingMatch m: matches) {
            if (m.getTeamAway().getTeamName().equals("KK Hustra Uhrovec") || m.getTeamHome().getTeamName().equals("KK Hustra Uhrovec")) {
                filtered.add(m);
            }
        }
        return filtered;
    }

    @Override
    public String deleteMatch(Integer id) {

        UpcomingMatch match = upcomingMatchRepo.findById(id).orElse(null);
        if (match == null) {
            return "Match doesnt exist";
        } else {
            upcomingMatchRepo.deleteById(id);
            return "Match " + match.getTeamHome().getTeamName() + " - " + match.getTeamAway().getTeamName() + " was deleted";

        }
    }
}
