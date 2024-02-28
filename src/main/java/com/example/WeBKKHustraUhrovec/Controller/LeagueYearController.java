package com.example.WeBKKHustraUhrovec.Controller;

import com.example.WeBKKHustraUhrovec.Entity.LeagueYear;
import com.example.WeBKKHustraUhrovec.Service.LeagueYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/leagueYear")
public class LeagueYearController {

    @Autowired
    private LeagueYearService leagueYearService;

    @PostMapping(path = "/save")
    public LeagueYear addLeagueYear(@RequestParam String leagueYear) {
        return leagueYearService.addLeagueYear(leagueYear);
    }

    @GetMapping(path = "/getAll")
    public List<LeagueYear> getAll() {
        return leagueYearService.getAllLeagueYears();
    }

    @DeleteMapping(path = "/delete")
    public void deleteYear(@RequestParam String id) {
        leagueYearService.deleteLeagueYear(id);
    }
}
