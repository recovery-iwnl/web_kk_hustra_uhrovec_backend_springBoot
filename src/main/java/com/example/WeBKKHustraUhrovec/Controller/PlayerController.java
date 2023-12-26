package com.example.WeBKKHustraUhrovec.Controller;


import com.example.WeBKKHustraUhrovec.Entity.Player;
import com.example.WeBKKHustraUhrovec.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/v1/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping(path = "/save")
    public Player savePlayer(@RequestParam String id, @RequestBody Player player) {
        return playerService.addPlayer(id, player);
    }
    @GetMapping(path = "/getPlayer")
    public Optional<Player> getPlayer(@RequestParam String id) {
        return playerService.getPlayer(id);
    }
    @GetMapping(path = "/getPlayersList")
    public List<Player> getAllPlayers() {return playerService.getAllPlayers();}
    @DeleteMapping(path = "/deletePlayer")
    public String deletePlayer(@RequestParam Integer id) {
        return playerService.deletePlayer(id);
    }
    @PutMapping(path = "/updatePlayer")
    public Player updatePlayer(@RequestBody Player player) {
        return playerService.updatePlayer(player);
    }

}
