package com.example.WeBKKHustraUhrovec.Controller;


import com.example.WeBKKHustraUhrovec.Entity.Player;
import com.example.WeBKKHustraUhrovec.Entity.User;
import com.example.WeBKKHustraUhrovec.Enum.UserRole;
import com.example.WeBKKHustraUhrovec.Service.PlayerService;
import com.example.WeBKKHustraUhrovec.Service.UserService;
import com.example.WeBKKHustraUhrovec.jwt.JwtTokenUtil;
import com.example.WeBKKHustraUhrovec.jwt.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/v1/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private Validation validation;


    @PostMapping(path = "/save")
    public ResponseEntity<?> savePlayer(@RequestParam String id,
                                             @RequestBody Player player,
                                             @RequestHeader(value = "Authorization", required = false) String token) {
        ResponseEntity<?> validationResponse = validation.validateTokenAndGetUser(token);
        if (validationResponse != null) {
            return validationResponse;
        }

        Player savedPlayer = playerService.addPlayer(id, player);
        return ResponseEntity.ok(savedPlayer);
    }

    @PostMapping(path = "/saveUhrovec")
    public ResponseEntity<?> savePlayerUhrovec(@RequestBody Player player,
                                                    @RequestHeader(value = "Authorization", required = false) String token) {
        ResponseEntity<?> validationResponse = validation.validateTokenAndGetUser(token);
        if (validationResponse != null) {
            return validationResponse;
        }

        Player savedPlayer = playerService.addPlayerUhrovec(player);
        return ResponseEntity.ok(savedPlayer);
    }
    @GetMapping(path = "/getPlayer")
    public Optional<Player> getPlayer(@RequestParam String id) {
        return playerService.getPlayer(id);
    }

    @GetMapping(path = "/getPlayerByName")
    public Optional<Player> getPlayerByName(@RequestParam String name, @RequestParam String surname) {
        return playerService.getPlayerByName(name, surname);
    }

    @GetMapping(path = "/getTeamNameByPlayer")
    public Optional<String> getTeamNameByPlayer(@RequestParam int id) {
        return playerService.getTeamNameByPlayer(id);
    }

    @GetMapping(path = "/getAge")
    public String getAge(@RequestParam String id) {
        return playerService.getAge(id);
    }

    @GetMapping(path = "/getPlayersList")
    public List<Player> getAllPlayers() {return playerService.getAllPlayers();}
    @DeleteMapping(path = "/deletePlayer")
    public ResponseEntity<?> deletePlayer(@RequestParam Integer id,
                                               @RequestHeader(value = "Authorization", required = false) String token) {
        ResponseEntity<?> validationResponse = validation.validateTokenAndGetUser(token);
        if (validationResponse != null) {
            return validationResponse;
        }

        String result = playerService.deletePlayer(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping(path = "/updatePlayer")
    public ResponseEntity<?> updatePlayer(@RequestBody Player player,
                                               @RequestHeader(value = "Authorization", required = false) String token) {
        ResponseEntity<?> validationResponse = validation.validateTokenAndGetUser(token);
        if (validationResponse != null) {
            return validationResponse;
        }

        Player updatedPlayer = playerService.updatePlayer(player);
        if (updatedPlayer != null) {
            return ResponseEntity.ok(updatedPlayer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
