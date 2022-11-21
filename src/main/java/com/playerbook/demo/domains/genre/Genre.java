package com.playerbook.demo.domains.genre;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.playerbook.demo.domains.game.Game;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "genreList")
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
