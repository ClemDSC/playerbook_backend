package com.playerbook.demo.genre;

import com.playerbook.demo.game.Game;

import java.util.List;

public class Genre {

    private Long id;
    private String name;
    private List<Game> gameList;

    public Genre(Long id, String name, List<Game> gameList) {
        this.id = id;
        this.name = name;
        this.gameList = gameList;
    }

    public Genre() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }
}
