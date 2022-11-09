package com.playerbook.demo.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // create
    @PostMapping("/add")
    public ResponseEntity<Game> addGame(@RequestBody Game game){
        Game newGame = gameService.addGame(game);
        return new ResponseEntity<>(newGame, HttpStatus.OK);
    }

    // read
    @GetMapping
    public ResponseEntity<List<Game>> getAllGames() {
        List<Game> allGames = gameService.findAllGames();
        return new ResponseEntity<>(allGames, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getOneGame(@PathVariable("id") Long id) {
        Game oneGame = gameService.findGameById(id);
        return new ResponseEntity<>(oneGame, HttpStatus.OK);
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable("id") Long id, @RequestBody Game game) {
        Game updatedGame = gameService.updateGameById(id, game);
        return new ResponseEntity<>(updatedGame, HttpStatus.OK);
    }

    // delete
    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable("id") Long id){
        gameService.deleteGameById(id);
        new ResponseEntity<>(HttpStatus.OK);
    }
}
