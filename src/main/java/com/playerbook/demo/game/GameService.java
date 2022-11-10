package com.playerbook.demo.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    // create
    public Game addGame(Game game){
        return gameRepository.save(game);
    }

    // read
    public List<Game> findAllGames(){
        return gameRepository.findAll();
    }

    public Game findGameById(Long id){
        return gameRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("sorry, id " + id + " not found")
        );
    }

    // update
    public Game updateGameById(Long id, Game game){
        Game gameFound = gameRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("sorry, id " + id + " not found")
        );
        gameFound.setName(game.getName());
        gameFound.setPhotoUrl(game.getPhotoUrl());
        gameFound.setGameUrl(game.getGameUrl());
        gameFound.setGenreList(game.getGenreList());
        gameFound.setUserList(game.getUserList());
        gameFound.setUserGameInfoList(game.getUserGameInfoList());

        return gameRepository.save(gameFound);
    }

    // delete

    public void deleteGameById(Long id){
        gameRepository.deleteById(id);
    }
}
