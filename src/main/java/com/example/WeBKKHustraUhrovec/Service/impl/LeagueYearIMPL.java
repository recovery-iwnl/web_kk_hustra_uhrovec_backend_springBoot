package com.example.WeBKKHustraUhrovec.Service.impl;

import com.example.WeBKKHustraUhrovec.Entity.LeagueYear;
import com.example.WeBKKHustraUhrovec.Repo.LeagueYearRepo;
import com.example.WeBKKHustraUhrovec.Service.LeagueYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueYearIMPL implements LeagueYearService {

    @Autowired
    private LeagueYearRepo leagueYearRepo;

    @Override
    public LeagueYear addLeagueYear(String year) {
        LeagueYear leagueYear = new LeagueYear(year);
        return leagueYearRepo.save(leagueYear);
    }

    @Override
    public List<LeagueYear> getAllLeagueYears() {
        return leagueYearRepo.findAll();
    }

    @Override
    public String updateLeagueYear(String id, String year) {
        LeagueYear yearN = leagueYearRepo.findById(Integer.valueOf(id)).orElse(null);
        if (yearN != null) {
            yearN.setYear(year);
            leagueYearRepo.save(yearN);
            return "League year has been updated!";
        } else {
            return "League year doesn't exist!";
        }

    }

    @Override
    public String deleteLeagueYear(String id) {
        LeagueYear year = leagueYearRepo.findById(Integer.valueOf(id)).orElse(null);
        if (year != null) {
            leagueYearRepo.delete(year);
            return "Year deleted successfully!";
        } else {
            return "Year doesn't exsit!";
        }
    }
}
