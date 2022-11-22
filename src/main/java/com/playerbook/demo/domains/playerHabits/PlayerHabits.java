package com.playerbook.demo.domains.playerHabits;

import com.playerbook.demo.domains.user.AppUser;

import javax.persistence.*;

@Entity
public class PlayerHabits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Long frequencyPerWeek;
    private Long sessionInHours;
    private boolean nocturnal;
    private boolean hotBlooded;
    private boolean leader;
    private boolean pve;
    private boolean pvp;

    @OneToOne(mappedBy = "playerHabits")
    private AppUser appUser;

    public PlayerHabits(Long id, Long frequencyPerWeek, Long sessionInHours, boolean nocturnal, boolean hotBlooded, boolean leader, boolean pve, boolean pvp, AppUser appUser) {
        this.id = id;
        this.frequencyPerWeek = frequencyPerWeek;
        this.sessionInHours = sessionInHours;
        this.nocturnal = nocturnal;
        this.hotBlooded = hotBlooded;
        this.leader = leader;
        this.pve = pve;
        this.pvp = pvp;
        this.appUser = appUser;
    }

    public PlayerHabits() {
    }

    public Long getId() {
        return id;
    }

    public Long getFrequencyPerWeek() {
        return frequencyPerWeek;
    }

    public Long getSessionInHours() {
        return sessionInHours;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFrequencyPerWeek(Long frequencyPerWeek) {
        this.frequencyPerWeek = frequencyPerWeek;
    }

    public void setSessionInHours(Long sessionInHours) {
        this.sessionInHours = sessionInHours;
    }

    public AppUser getUser() {
        return appUser;
    }

    public void setUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public boolean isNocturnal() {
        return nocturnal;
    }

    public void setNocturnal(boolean nocturnal) {
        this.nocturnal = nocturnal;
    }

    public boolean isHotBlooded() {
        return hotBlooded;
    }

    public void setHotBlooded(boolean hotBlooded) {
        this.hotBlooded = hotBlooded;
    }

    public boolean isLeader() {
        return leader;
    }

    public void setLeader(boolean leader) {
        this.leader = leader;
    }

    public boolean isPve() {
        return pve;
    }

    public void setPve(boolean pve) {
        this.pve = pve;
    }

    public boolean isPvp() {
        return pvp;
    }

    public void setPvp(boolean pvp) {
        this.pvp = pvp;
    }
}
