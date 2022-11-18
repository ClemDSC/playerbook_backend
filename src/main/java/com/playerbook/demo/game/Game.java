package com.playerbook.demo.game;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.playerbook.demo.genre.Genre;
import com.playerbook.demo.user.User;
import com.playerbook.demo.userGameInfo.UserGameInfo;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String photoUrl;
    private String gameUrl;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Genre> genreList;

    @ManyToMany(mappedBy = "gameList")
    private List<User> userList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private List<UserGameInfo> userGameInfoList;


    public Game(Long id, String name, String photoUrl, String gameUrl, List<Genre> genreList, List<User> userList, List<UserGameInfo> userGameInfoList) {
        this.id = id;
        this.name = name;
        this.photoUrl = photoUrl;
        this.gameUrl = gameUrl;
        this.genreList = genreList;
        this.userList = userList;
        this.userGameInfoList = userGameInfoList;
    }

    public Game() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getGameUrl() {
        return gameUrl;
    }

    public List<Genre> getGenreList() {
        return genreList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public List<UserGameInfo> getUserGameInfoList() {
        return userGameInfoList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public void setGameUrl(String gameUrl) {
        this.gameUrl = gameUrl;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void setUserGameInfoList(List<UserGameInfo> userGameInfoList) {
        this.userGameInfoList = userGameInfoList;
    }
}
