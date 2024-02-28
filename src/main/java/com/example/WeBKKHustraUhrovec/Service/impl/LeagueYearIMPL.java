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
        LeagueYear leagueYear = new LeagueYear();
        leagueYear.setYear(year);
        return leagueYearRepo.save(leagueYear);
    }

    @Override
    public List<LeagueYear> getAllLeagueYears() {
        return leagueYearRepo.findAll();
    }

    @Override
    public void deleteLeagueYear(String id) {
        leagueYearRepo.findById(Integer.valueOf(id)).ifPresent(leagueYear -> leagueYearRepo.delete(leagueYear));
    }
}
