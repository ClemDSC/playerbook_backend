package com.playerbook.demo.userGameInfo;

import com.playerbook.demo.game.Game;
import com.playerbook.demo.user.User;

import javax.persistence.ManyToOne;

public class UserGameInfo {

    private Long id;
    private String userPseudo;
    private String guild;
    private Long level;
    private String rank;
    private String difficulty;
    private String serverName;

    @ManyToOne()
    private User user;

    @ManyToOne()
    private Game game;

    public UserGameInfo(Long id, String userPseudo, String guild, Long level, String rank, String difficulty, String serverName, User user, Game game) {
        this.id = id;
        this.userPseudo = userPseudo;
        this.guild = guild;
        this.level = level;
        this.rank = rank;
        this.difficulty = difficulty;
        this.serverName = serverName;
        this.user = user;
        this.game = game;
    }

    public UserGameInfo() {
    }

    public Long getId() {
        return id;
    }

    public String getUserPseudo() {
        return userPseudo;
    }

    public String getGuild() {
        return guild;
    }

    public Long getLevel() {
        return level;
    }

    public String getRank() {
        return rank;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getServerName() {
        return serverName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserPseudo(String userPseudo) {
        this.userPseudo = userPseudo;
    }

    public void setGuild(String guild) {
        this.guild = guild;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
