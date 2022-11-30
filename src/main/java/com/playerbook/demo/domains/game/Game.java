package com.playerbook.demo.domains.game;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.playerbook.demo.domains.genre.Genre;
import com.playerbook.demo.domains.user.AppUser;
import com.playerbook.demo.domains.userGameInfo.UserGameInfo;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
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
    private List<AppUser> appUserList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private List<UserGameInfo> userGameInfoList;


    public Game(Long id, String name, String photoUrl, String gameUrl, List<Genre> genreList, List<AppUser> appUserList, List<UserGameInfo> userGameInfoList) {
        this.id = id;
        this.name = name;
        this.photoUrl = photoUrl;
        this.gameUrl = gameUrl;
        this.genreList = genreList;
        this.appUserList = appUserList;
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

    public List<AppUser> getUserList() {
        return appUserList;
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

    public void setUserList(List<AppUser> appUserList) {
        this.appUserList = appUserList;
    }

    public void setUserGameInfoList(List<UserGameInfo> userGameInfoList) {
        this.userGameInfoList = userGameInfoList;
    }
}
