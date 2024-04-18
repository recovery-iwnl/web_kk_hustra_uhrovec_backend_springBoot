package com.example.WeBKKHustraUhrovec.Controller;

import com.example.WeBKKHustraUhrovec.Entity.LeagueYear;
import com.example.WeBKKHustraUhrovec.Entity.User;
import com.example.WeBKKHustraUhrovec.Enum.UserRole;
import com.example.WeBKKHustraUhrovec.Service.LeagueYearService;
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
@RequestMapping("api/v1/leagueYear")
public class LeagueYearController {

    @Autowired
    private LeagueYearService leagueYearService;

    @Autowired
    private Validation validation;

    @PostMapping(path = "/save")
    public ResponseEntity<?> addLeagueYear(@RequestParam String leagueYear,
                                                    @RequestHeader(value = "Authorization", required = false) String token) {
        ResponseEntity<?> validationResponse = validation.validateTokenAndGetUser(token);
        if (validationResponse != null) {
            return validationResponse;
        }

        LeagueYear savedLeagueYear = leagueYearService.addLeagueYear(leagueYear);
        return ResponseEntity.ok(savedLeagueYear);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> updateLeagueYear(@RequestParam String id, @RequestParam String year,
                                           @RequestHeader(value = "Authorization", required = false) String token) {
        ResponseEntity<?> validationResponse = validation.validateTokenAndGetUser(token);
        if (validationResponse != null) {
            return validationResponse;
        }

        String updated = leagueYearService.updateLeagueYear(id,year);
        return ResponseEntity.ok(updated);
    }

    @GetMapping(path = "/getAll")
    public List<LeagueYear> getAll() {
        return leagueYearService.getAllLeagueYears();
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<?> deleteYear(@RequestParam String id,
                                           @RequestHeader(value = "Authorization", required = false) String token) {
        ResponseEntity<?> validationResponse = validation.validateTokenAndGetUser(token);
        if (validationResponse != null) {
            return validationResponse;
        }

        String resp = leagueYearService.deleteLeagueYear(id);
        return ResponseEntity.ok(resp);
    }
}
