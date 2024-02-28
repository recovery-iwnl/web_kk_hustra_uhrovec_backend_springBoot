package com.example.WeBKKHustraUhrovec.Controller;

import com.example.WeBKKHustraUhrovec.Entity.Result;
import com.example.WeBKKHustraUhrovec.Service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/v1/result")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @PostMapping(path = "/saveSimple")
    public Result saveResultSimple(@RequestParam String teamIdHome,@RequestParam String teamIdAway,
                             @RequestBody Result result) {
        return resultService.addResultSimple(teamIdHome, teamIdAway, result);
    }

    @GetMapping(path = "/getResult")
    public Optional<Result> getResult(@RequestParam String id) {
        return resultService.getResult(id);
    }

    @GetMapping(path = "/getResultsByYear")
    public List<Result> getResultsByYear(@RequestParam String id) {
        return resultService.getResultsByLeagueYear(id);
    }

    @GetMapping(path = "/getResultsList")
    public List<Result> getAllResults() {
        return resultService.getAllResults();
    }

    @GetMapping(path = "/getResultsUhrovecList")
    public List<Result> getResultsUhrovec() {
        return resultService.getResultsUhrovec();
    }

    @DeleteMapping(path = "/deleteResult")
    public String deleteResult(@RequestParam Integer id) {
        return resultService.deleteResult(id);
    }

}
