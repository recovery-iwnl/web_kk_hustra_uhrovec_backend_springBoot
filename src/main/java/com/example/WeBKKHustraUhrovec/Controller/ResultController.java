package com.example.WeBKKHustraUhrovec.Controller;

import com.example.WeBKKHustraUhrovec.Entity.Result;
import com.example.WeBKKHustraUhrovec.Service.ResultService;
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

    @PostMapping(path = "/save")
    public Result saveResult(@RequestParam String teamIdHome,@RequestParam String teamIdAway,
                             @RequestParam String player1IdHome,
                             @RequestParam String player2IdHome,
                             @RequestParam String player3IdHome,
                             @RequestParam String player4IdHome,
                             @RequestParam String player5IdHome,
                             @RequestParam String player6IdHome,
                             @RequestParam String player1IdAway,
                             @RequestParam String player2IdAway,
                             @RequestParam String player3IdAway,
                             @RequestParam String player4IdAway,
                             @RequestParam String player5IdAway,
                             @RequestParam String player6IdAway,
                             @RequestBody Result result) {
        return resultService.addResult(teamIdHome, teamIdAway,
                player1IdHome, player2IdHome, player3IdHome, player4IdHome, player5IdHome, player6IdHome,
                player1IdAway, player2IdAway, player3IdAway, player4IdAway, player5IdAway, player6IdAway,
                result);
    }

    @PostMapping(path = "/saveSimple")
    public Result saveResultSimple(@RequestParam String teamIdHome,@RequestParam String teamIdAway,
                             @RequestBody Result result) {
        return resultService.addResultSimple(teamIdHome, teamIdAway, result);
    }

    @GetMapping(path = "/getResult")
    public Optional<Result> getResult(@RequestParam String id) {
        return resultService.getResult(id);
    }

    @GetMapping(path = "/getResultsList")
    public List<Result> getAllResults() {
        return resultService.getAllResults();
    }

    @DeleteMapping(path = "/deleteResult")
    public String deleteResult(@RequestParam Integer id) {
        return resultService.deleteResult(id);
    }
    @PutMapping(path = "/updateResult")
    public Result updateResult(@RequestBody Result result) {
        return resultService.updateResult(result);
    }

}
