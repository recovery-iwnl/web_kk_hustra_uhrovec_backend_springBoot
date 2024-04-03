package com.example.WeBKKHustraUhrovec.Controller;

import com.example.WeBKKHustraUhrovec.Entity.Result;
import com.example.WeBKKHustraUhrovec.Entity.User;
import com.example.WeBKKHustraUhrovec.Enum.UserRole;
import com.example.WeBKKHustraUhrovec.Service.ResultService;
import com.example.WeBKKHustraUhrovec.Service.UserService;
import com.example.WeBKKHustraUhrovec.jwt.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/v1/result")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @PostMapping(path = "/saveSimple")
    public ResponseEntity<Result> saveResultSimple(@RequestParam String teamIdHome,
                                                   @RequestParam String teamIdAway,
                                                   @RequestBody Result result,
                                                   @RequestHeader(value = "Authorization", required = false) String token) {
        if (token == null || jwtTokenUtil.isTokenExpired(token.substring(7))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        User user = userService.getUserByToken(token.substring(7));
        if (user.getRole() != UserRole.ADMIN) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }

        Result savedResult = resultService.addResultSimple(teamIdHome, teamIdAway, result);
        return ResponseEntity.ok(savedResult);
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
    public List<Result> getResultsUhrovec(@RequestParam String id) {
        return resultService.getResultsUhrovecByLeagueYear(id);
    }

    @DeleteMapping(path = "/deleteResult")
    public ResponseEntity<String> deleteResult(@RequestParam Integer id,
                                               @RequestHeader(value = "Authorization", required = false) String token) {
        if (token == null || jwtTokenUtil.isTokenExpired(token.substring(7))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }
        User user = userService.getUserByToken(token.substring(7));
        if (user.getRole() != UserRole.ADMIN) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }

        String result = resultService.deleteResult(id);
        return ResponseEntity.ok(result);
    }

}
