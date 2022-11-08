package com.playerbook.demo.userBehavior;

import com.playerbook.demo.user.User;

import javax.persistence.OneToOne;

public class UserBehavior {

    private Long id;
    private boolean isCasual;
    private boolean isProactive;
    private boolean isExtravert;
    private boolean isPro;
    private String employeer;

    @OneToOne(mappedBy = "userBehavior")
    private User user;

    public UserBehavior(Long id, boolean isCasual, boolean isProactive, boolean isExtravert, boolean isPro, String employeer, User user) {
        this.id = id;
        this.isCasual = isCasual;
        this.isProactive = isProactive;
        this.isExtravert = isExtravert;
        this.isPro = isPro;
        this.employeer = employeer;
        this.user = user;
    }

    public UserBehavior() {
    }

    public Long getId() {
        return id;
    }

    public boolean isCasual() {
        return isCasual;
    }

    public boolean isProactive() {
        return isProactive;
    }

    public boolean isExtravert() {
        return isExtravert;
    }

    public boolean isPro() {
        return isPro;
    }

    public String getEmployeer() {
        return employeer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCasual(boolean casual) {
        isCasual = casual;
    }

    public void setProactive(boolean proactive) {
        isProactive = proactive;
    }

    public void setExtravert(boolean extravert) {
        isExtravert = extravert;
    }

    public void setPro(boolean pro) {
        isPro = pro;
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
}
