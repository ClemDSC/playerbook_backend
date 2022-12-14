package com.playerbook.demo.domains.userGameInfo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.playerbook.demo.domains.game.Game;
import com.playerbook.demo.domains.user.AppUser;


import javax.persistence.*;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class UserGameInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Long ownerId;
    private String userPseudo;
    private String guild;
    private Long level;
    private String pilouRank;
    private String difficulty;
    private String serverName;

    @ManyToOne()
    private AppUser appUser;

    @ManyToOne()
    private Game game;

    public UserGameInfo(Long id, Long ownerId, String userPseudo, String guild, Long level, String pilouRank, String difficulty, String serverName, AppUser appUser, Game game) {
        this.id = id;
        this.ownerId = ownerId;
        this.userPseudo = userPseudo;
        this.guild = guild;
        this.level = level;
        this.pilouRank = pilouRank;
        this.difficulty = difficulty;
        this.serverName = serverName;
        this.appUser = appUser;
        this.game = game;
    }

    public UserGameInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getUserPseudo() {
        return userPseudo;
    }

    public void setUserPseudo(String userPseudo) {
        this.userPseudo = userPseudo;
    }

    public String getGuild() {
        return guild;
    }

    public void setGuild(String guild) {
        this.guild = guild;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public String getPilouRank() {
        return pilouRank;
    }

    public void setPilouRank(String pilouRank) {
        this.pilouRank = pilouRank;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
