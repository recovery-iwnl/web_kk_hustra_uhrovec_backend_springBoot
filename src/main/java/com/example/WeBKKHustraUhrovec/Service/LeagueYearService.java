package com.example.WeBKKHustraUhrovec.Service;

import com.example.WeBKKHustraUhrovec.Entity.LeagueYear;
import com.example.WeBKKHustraUhrovec.Entity.Player;
import com.example.WeBKKHustraUhrovec.Entity.PlayerResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LeagueYearService {

    LeagueYear addLeagueYear(String year);

    List<LeagueYear> getAllLeagueYears();

    void deleteLeagueYear(String id);
}
