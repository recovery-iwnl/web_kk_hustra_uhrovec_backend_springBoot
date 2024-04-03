package com.example.WeBKKHustraUhrovec.Controller;

import com.example.WeBKKHustraUhrovec.Entity.LeagueYear;
import com.example.WeBKKHustraUhrovec.Entity.User;
import com.example.WeBKKHustraUhrovec.Enum.UserRole;
import com.example.WeBKKHustraUhrovec.Service.LeagueYearService;
import com.example.WeBKKHustraUhrovec.Service.UserService;
import com.example.WeBKKHustraUhrovec.jwt.JwtTokenUtil;
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
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @PostMapping(path = "/save")
    public ResponseEntity<LeagueYear> addLeagueYear(@RequestParam String leagueYear,
                                                    @RequestHeader(value = "Authorization", required = false) String token) {
        if (token == null || jwtTokenUtil.isTokenExpired(token.substring(7))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        User user = userService.getUserByToken(token.substring(7));
        if (user.getRole() != UserRole.ADMIN) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }

        LeagueYear savedLeagueYear = leagueYearService.addLeagueYear(leagueYear);
        return ResponseEntity.ok(savedLeagueYear);
    }

    @GetMapping(path = "/getAll")
    public List<LeagueYear> getAll() {
        return leagueYearService.getAllLeagueYears();
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<Void> deleteYear(@RequestParam String id,
                                           @RequestHeader(value = "Authorization", required = false) String token) {
        if (token == null || jwtTokenUtil.isTokenExpired(token.substring(7))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        User user = userService.getUserByToken(token.substring(7));
        if (user.getRole() != UserRole.ADMIN) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }

        leagueYearService.deleteLeagueYear(id);
        return ResponseEntity.noContent().build();
    }
}
