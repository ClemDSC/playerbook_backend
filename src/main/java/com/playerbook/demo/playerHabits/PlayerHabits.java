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
    private boolean isNocturnal;
    private boolean isHotBlooded;
    private boolean isLeader;
    private boolean isPVE;
    private boolean isPVP;

    @OneToOne(mappedBy = "playerHabits")
    private User user;

    public PlayerHabits(Long id,
                        Long frequencyPerWeek,
                        Long sessionInHours,
                        boolean isNocturnal,
                        boolean isHotBlooded,
                        boolean isLeader,
                        boolean isPVE,
                        boolean isPVP,
                        User user) {
        this.id = id;
        this.frequencyPerWeek = frequencyPerWeek;
        this.sessionInHours = sessionInHours;
        this.isNocturnal = isNocturnal;
        this.isHotBlooded = isHotBlooded;
        this.isLeader = isLeader;
        this.isPVE = isPVE;
        this.isPVP = isPVP;
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

    public boolean isNocturnal() {
        return isNocturnal;
    }

    public boolean isHotBlooded() {
        return isHotBlooded;
    }

    public boolean isLeader() {
        return isLeader;
    }

    public boolean isPVE() {
        return isPVE;
    }

    public boolean isPVP() {
        return isPVP;
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

    public void setNocturnal(boolean nocturnal) {
        isNocturnal = nocturnal;
    }

    public void setHotBlooded(boolean hotBlooded) {
        isHotBlooded = hotBlooded;
    }

    public void setLeader(boolean leader) {
        isLeader = leader;
    }

    public void setPVE(boolean PVE) {
        isPVE = PVE;
    }

    public void setPVP(boolean PVP) {
        isPVP = PVP;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
