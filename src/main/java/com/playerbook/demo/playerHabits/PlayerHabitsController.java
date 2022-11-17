package com.playerbook.demo.playerHabits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/playerhabits")
public class PlayerHabitsController {

    private final PlayerHabitsService playerHabitsService;

    @Autowired
    public PlayerHabitsController(PlayerHabitsService playerHabitsService) {
        this.playerHabitsService = playerHabitsService;
    }

    // create
    @PostMapping("/add")
    public ResponseEntity<PlayerHabits> addPlayerHabits(@RequestBody PlayerHabits playerHabits){
        PlayerHabits newPlayerHabits = playerHabitsService.addPlayerHabits(playerHabits);
        return new ResponseEntity<>(newPlayerHabits, HttpStatus.OK);
    }

    // read
    @GetMapping
    public ResponseEntity<List<PlayerHabits>> getAllPlayerHabits() {
        List<PlayerHabits> allPlayerHabits = playerHabitsService.findAllPlayerHabits();
        return new ResponseEntity<>(allPlayerHabits, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerHabits> getOnePlayerHabits(@PathVariable("id") Long id) {
        PlayerHabits onePlayerHabits = playerHabitsService.findPlayerHabitsById(id);
        return new ResponseEntity<>(onePlayerHabits, HttpStatus.OK);
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<PlayerHabits> updatePlayerHabits(@PathVariable("id") Long id, @RequestBody PlayerHabits playerHabits) {
        PlayerHabits updatedPlayerHabits = playerHabitsService.updatePlayerHabitsById(id, playerHabits);
        return new ResponseEntity<>(updatedPlayerHabits, HttpStatus.OK);
    }

    // delete
    @DeleteMapping("/{id}")
    public void deletePlayerHabits(@PathVariable("id") Long id){
        playerHabitsService.deletePlayerHabitsById(id);
        new ResponseEntity<>(HttpStatus.OK);
    }
}
