package com.playerbook.demo.domains.userBehavior;

import com.playerbook.demo.domains.user.AppUser;

import javax.persistence.*;

@Entity
public class UserBehavior {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private boolean casual;
    private boolean proactive;
    private boolean extravert;
    private boolean pro;
    private String employeer;

    @OneToOne(mappedBy = "userBehavior")
    private AppUser appUser;

    public UserBehavior(Long id, boolean casual, boolean proactive, boolean extravert, boolean pro, String employeer, AppUser appUser) {
        this.id = id;
        this.casual = casual;
        this.proactive = proactive;
        this.extravert = extravert;
        this.pro = pro;
        this.employeer = employeer;
        this.appUser = appUser;
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

    public AppUser getUser() {
        return appUser;
    }

    public void setUser(AppUser appUser) {
        this.appUser = appUser;
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
