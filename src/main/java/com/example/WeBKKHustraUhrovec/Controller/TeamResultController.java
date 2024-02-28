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
    public Long getMatchesPlayed(@RequestParam String id) {
        return teamResultService.getMatchesPlayed(id);
    }

    @GetMapping(path = "/getMatchesWon")
    public Integer getMatchesWon(@RequestParam String id) {
        return teamResultService.getMatchesWon(id);
    }

    @GetMapping(path = "/getMatchesLost")
    public Integer getMatchesLost(@RequestParam String id) {
        return teamResultService.getMatchesLost(id);
    }

    @GetMapping(path = "/getMatchesDrawn")
    public Integer getMatchesDrawn(@RequestParam String id) {
        return teamResultService.getMatchesDrawn(id);
    }

    @GetMapping(path = "/getAverage")
    public Double getAverage(@RequestParam String id) {
        return teamResultService.getAverageScore(id);
    }

    @GetMapping(path = "/getPoints")
    public Integer getPoints(@RequestParam String id) {
        return teamResultService.getPoints(id);
    }
}
