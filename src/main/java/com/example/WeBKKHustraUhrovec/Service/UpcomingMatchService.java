package com.example.WeBKKHustraUhrovec.Service;


import com.example.WeBKKHustraUhrovec.Entity.UpcomingMatch;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UpcomingMatchService {

    UpcomingMatch addMatch(String teamIdHome, String teamIdAway, UpcomingMatch upcomingMatch);

    List<UpcomingMatch> getAllMatches();

    List<UpcomingMatch> getMatchesUhrovec();

    String deleteMatch(Integer id);
}
