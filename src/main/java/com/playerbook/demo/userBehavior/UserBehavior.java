package com.playerbook.demo.userBehavior;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.playerbook.demo.user.User;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class UserBehavior {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private boolean casual;
    private boolean proactive;
    private boolean extravert;
    private boolean pro;
    private String employeer;

    @OneToOne(mappedBy = "userBehavior")
    private User user;

    public UserBehavior(Long id, boolean casual, boolean proactive, boolean extravert, boolean pro, String employeer, User user) {
        this.id = id;
        this.casual = casual;
        this.proactive = proactive;
        this.extravert = extravert;
        this.pro = pro;
        this.employeer = employeer;
        this.user = user;
    }

    public UserBehavior() {
    }

    public Long getId() {
        return id;
    }

    public String getEmployeer() {
        return employeer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmployeer(String employeer) {
        this.employeer = employeer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isCasual() {
        return casual;
    }

    public void setCasual(boolean casual) {
        this.casual = casual;
    }

    public boolean isProactive() {
        return proactive;
    }

    public void setProactive(boolean proactive) {
        this.proactive = proactive;
    }

    public boolean isExtravert() {
        return extravert;
    }

    public void setExtravert(boolean extravert) {
        this.extravert = extravert;
    }

    public boolean isPro() {
        return pro;
    }

    public void setPro(boolean pro) {
        this.pro = pro;
    }
}
