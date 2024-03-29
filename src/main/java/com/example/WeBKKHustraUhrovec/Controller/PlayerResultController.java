package com.example.WeBKKHustraUhrovec.Controller;

import com.example.WeBKKHustraUhrovec.Service.PlayerResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("api/v1/playerResult")
public class PlayerResultController {

    @Autowired
    private PlayerResultService playerResultService;

    @GetMapping(path = "/getMatchesPlayed")
    public Long getMatchesPlayed(@RequestParam String id, @RequestParam String leagueYearId ) {
        return playerResultService.getMatchesPlayed(id, leagueYearId);
    }

    @GetMapping(path = "/getDuelsWon")
    public Long getDuelsWon(@RequestParam String id, @RequestParam String leagueYearId ) {
        return playerResultService.getMatchesWon(id, leagueYearId);
    }

    @GetMapping(path = "/getDuelsDrawn")
    public Long getDuelsDrawn(@RequestParam String id, @RequestParam String leagueYearId ) {
        return playerResultService.getMatchesDrawn(id, leagueYearId);
    }

    @GetMapping(path = "/getDuelsLost")
    public Long getDuelsLost(@RequestParam String id, @RequestParam String leagueYearId ) {
        return playerResultService.getMatchesLost(id, leagueYearId);
    }

    @GetMapping(path = "/getPlayersBest")
    public Integer getPlayersBest(@RequestParam String id, @RequestParam String leagueYearId ) {
        return playerResultService.getPlayersBest(id, leagueYearId);
    }

    @GetMapping(path = "/getPlayersWorst")
    public Integer getPlayersWorst(@RequestParam String id, @RequestParam String leagueYearId ) {
        return playerResultService.getPlayersWorst(id, leagueYearId);
    }

    @GetMapping(path = "/getAverage")
    public Double getAverage(@RequestParam String id, @RequestParam String leagueYearId ) {
        return playerResultService.getAverageScore(id, leagueYearId);
    }
}
