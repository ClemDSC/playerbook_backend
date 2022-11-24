package com.playerbook.demo.domains.user;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.playerbook.demo.domains.game.Game;
import com.playerbook.demo.domains.playerHabits.PlayerHabits;
import com.playerbook.demo.domains.role.Role;
import com.playerbook.demo.domains.userBehavior.UserBehavior;
import com.playerbook.demo.domains.userGameInfo.UserGameInfo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String username;
    private String password;
    private String linkAvatar;
    private String country;
    private String biography;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "playerHabits_id", referencedColumnName = "id")
    private PlayerHabits playerHabits;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userBehavior_id", referencedColumnName = "id")
    private UserBehavior userBehavior;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Game> gameList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<UserGameInfo> userGameInfo;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roleList = new ArrayList<>();


    public AppUser(Long id,
                   String username,
                   String password,
                   String linkAvatar,
                   String country,
                   String biography,
                   PlayerHabits playerHabits,
                   UserBehavior userBehavior,
                   List<Game> gameList,
                   List<UserGameInfo> userGameInfo,
                   Collection<Role> roleList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.linkAvatar = linkAvatar;
        this.country = country;
        this.biography = biography;
        this.playerHabits = playerHabits;
        this.userBehavior = userBehavior;
        this.gameList = gameList;
        this.userGameInfo = userGameInfo;
        this.roleList = roleList;
    }

    public AppUser() {
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() { return password; }

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

    public Collection<Role> getRoleList() {
        return roleList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void setRoleList(Collection<Role> roleList) {
        this.roleList = roleList;
    }
}
