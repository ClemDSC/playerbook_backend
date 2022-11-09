package com.playerbook.demo.playerHabits;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.playerbook.demo.user.User;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
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
    private User user;

    public PlayerHabits(Long id, Long frequencyPerWeek, Long sessionInHours, boolean nocturnal, boolean hotBlooded, boolean leader, boolean pve, boolean pvp, User user) {
        this.id = id;
        this.frequencyPerWeek = frequencyPerWeek;
        this.sessionInHours = sessionInHours;
        this.nocturnal = nocturnal;
        this.hotBlooded = hotBlooded;
        this.leader = leader;
        this.pve = pve;
        this.pvp = pvp;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
