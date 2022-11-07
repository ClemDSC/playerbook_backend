package com.playerbook.demo.userBehavior;

public class UserBehavior {

    private Long id;
    private boolean isCasual;
    private boolean isProactive;
    private boolean isExtravert;
    private boolean isPro;
    private String employeer;
    private Long user_id;

    public UserBehavior(Long id, boolean isCasual, boolean isProactive, boolean isExtravert, boolean isPro, String employeer, Long user_id) {
        this.id = id;
        this.isCasual = isCasual;
        this.isProactive = isProactive;
        this.isExtravert = isExtravert;
        this.isPro = isPro;
        this.employeer = employeer;
        this.user_id = user_id;
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

    public Long getUser_id() {
        return user_id;
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

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}