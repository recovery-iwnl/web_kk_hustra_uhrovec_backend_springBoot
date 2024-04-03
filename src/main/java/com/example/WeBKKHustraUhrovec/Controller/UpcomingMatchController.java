package com.example.WeBKKHustraUhrovec.Controller;


import com.example.WeBKKHustraUhrovec.Entity.UpcomingMatch;
import com.example.WeBKKHustraUhrovec.Entity.User;
import com.example.WeBKKHustraUhrovec.Enum.UserRole;
import com.example.WeBKKHustraUhrovec.Service.UpcomingMatchService;
import com.example.WeBKKHustraUhrovec.Service.UserService;
import com.example.WeBKKHustraUhrovec.jwt.JwtTokenUtil;
import com.example.WeBKKHustraUhrovec.jwt.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/match")
public class UpcomingMatchController {

    @Autowired
    private UpcomingMatchService upcomingMatchService;

    @Autowired
    private Validation validation;

    @PostMapping(path = "/save")
    public ResponseEntity<?> saveMatch(@RequestParam String teamIdHome, @RequestParam String teamIdAway,
                                                   @RequestBody UpcomingMatch upcomingMatch,
                                                   @RequestHeader(value = "Authorization", required = false) String token) {
        ResponseEntity<?> validationResponse = validation.validateTokenAndGetUser(token);
        if (validationResponse != null) {
            return validationResponse;
        }

        UpcomingMatch savedMatch = upcomingMatchService.addMatch(teamIdHome, teamIdAway, upcomingMatch);
        return ResponseEntity.ok(savedMatch);
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
    public ResponseEntity<?> deleteMatch(@RequestParam Integer id,
                                              @RequestHeader(value = "Authorization", required = false) String token) {
        ResponseEntity<?> validationResponse = validation.validateTokenAndGetUser(token);
        if (validationResponse != null) {
            return validationResponse;
        }

        String result = upcomingMatchService.deleteMatch(id);
        return ResponseEntity.ok(result);
    }

}
