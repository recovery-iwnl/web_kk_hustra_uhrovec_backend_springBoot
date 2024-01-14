package com.example.WeBKKHustraUhrovec.Controller;


import com.example.WeBKKHustraUhrovec.Entity.UpcomingMatch;
import com.example.WeBKKHustraUhrovec.Service.UpcomingMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/match")
public class UpcomingMatchController {

    @Autowired
    private UpcomingMatchService upcomingMatchService;

    @PostMapping(path = "/save")
    public UpcomingMatch saveMatch(@RequestParam String teamIdHome, @RequestParam String teamIdAway,
                                   @RequestBody UpcomingMatch upcomingMatch) {
        return upcomingMatchService.addMatch(teamIdHome, teamIdAway, upcomingMatch);
    }

    @GetMapping(path = "/getMatchesList")
    public List<UpcomingMatch> getAllMatches() {
        return upcomingMatchService.getAllMatches();
    }

    @GetMapping(path = "/getMatchesUhrovecList")
    public List<UpcomingMatch> getMatchesUhrovec() {
        return upcomingMatchService.getMatchesUhrovec();
    }

    @DeleteMapping(path = "/deleteMatch")
    public String deleteMatch(@RequestParam Integer id) {
        return upcomingMatchService.deleteMatch(id);
    }

}
