package com.example.WeBKKHustraUhrovec.Controller;

import com.example.WeBKKHustraUhrovec.Service.PlayerResultService;
import com.example.WeBKKHustraUhrovec.Service.TeamResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/teamResult")
public class TeamResultController {

    @Autowired
    private TeamResultService teamResultService;

    @GetMapping(path = "/getMatchesPlayed")
    public Long getMatchesPlayed(@RequestParam String id, @RequestParam String leagueYearId ) {
        return teamResultService.getMatchesPlayed(id, leagueYearId);
    }

    @GetMapping(path = "/getMatchesWon")
    public Integer getMatchesWon(@RequestParam String id, @RequestParam String leagueYearId ) {
        return teamResultService.getMatchesWon(id, leagueYearId);
    }

    @GetMapping(path = "/getMatchesLost")
    public Integer getMatchesLost(@RequestParam String id, @RequestParam String leagueYearId ) {
        return teamResultService.getMatchesLost(id, leagueYearId);
    }

    @GetMapping(path = "/getMatchesDrawn")
    public Integer getMatchesDrawn(@RequestParam String id, @RequestParam String leagueYearId ) {
        return teamResultService.getMatchesDrawn(id, leagueYearId);
    }

    @GetMapping(path = "/getAverage")
    public Double getAverage(@RequestParam String id, @RequestParam String leagueYearId ) {
        return teamResultService.getAverageScore(id, leagueYearId);
    }

    @GetMapping(path = "/getPoints")
    public Integer getPoints(@RequestParam String id, @RequestParam String leagueYearId ) {
        return teamResultService.getPoints(id, leagueYearId);
    }
}
