package com.playerbook.demo.user;

import com.playerbook.demo.game.Game;
import com.playerbook.demo.playerHabits.PlayerHabits;
import com.playerbook.demo.userBehavior.UserBehavior;
import com.playerbook.demo.userGameInfo.UserGameInfo;

import java.util.List;

public class User {

    private Long id;
    private String name;
    private String linkAvatar;
    private String country;
    private String biography;
    private PlayerHabits playerHabits;
    private UserBehavior userBehavior;
    private List<Game> gameList;
    private List<UserGameInfo> userGameInfo;


    public User(Long id,
                String name,
                String linkAvatar,
                String country,
                String biography,
                PlayerHabits playerHabits,
                UserBehavior userBehavior,
                List<Game> gameList,
                List<UserGameInfo> userGameInfo) {
        this.id = id;
        this.name = name;
        this.linkAvatar = linkAvatar;
        this.country = country;
        this.biography = biography;
        this.playerHabits = playerHabits;
        this.userBehavior = userBehavior;
        this.gameList = gameList;
        this.userGameInfo = userGameInfo;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLinkAvatar() {
        return linkAvatar;
    }

    public String getCountry() {
        return country;
    }

    public String getBiography() {
        return biography;
    }

    public PlayerHabits getPlayerHabits() {
        return playerHabits;
    }

    public UserBehavior getUserBehavior() {
        return userBehavior;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public List<UserGameInfo> getUserGameInfo() {
        return userGameInfo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLinkAvatar(String linkAvatar) {
        this.linkAvatar = linkAvatar;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setPlayerHabits(PlayerHabits playerHabits) {
        this.playerHabits = playerHabits;
    }

    public void setUserBehavior(UserBehavior userBehavior) {
        this.userBehavior = userBehavior;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }

    public void setUserGameInfo(List<UserGameInfo> userGameInfo) {
        this.userGameInfo = userGameInfo;
    }
}
