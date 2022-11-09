package com.playerbook.demo.playerHabits;

import com.playerbook.demo.genre.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerHabitsService {

    private final PlayerHabitsRepository playerHabitsRepository;

    @Autowired
    public PlayerHabitsService(PlayerHabitsRepository playerHabitsRepository) {
        this.playerHabitsRepository = playerHabitsRepository;
    }

    // create
    public PlayerHabits addPlayerHabits(PlayerHabits playerHabits){
        return playerHabitsRepository.save(playerHabits);
    }

    // read
    public List<PlayerHabits> findAllPlayerHabits(){
        return playerHabitsRepository.findAll();
    }

    public PlayerHabits findPlayerHabitsById(Long id){
        return playerHabitsRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("sorry, id " + id + " not found")
        );
    }

    // update
    public PlayerHabits updatePlayerHabitsById(Long id, PlayerHabits playerHabits){
        PlayerHabits playerHabitsFound = playerHabitsRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("sorry, id " + id + " not found")
        );

        playerHabitsFound.setFrequencyPerWeek(playerHabits.getFrequencyPerWeek());
        playerHabitsFound.setSessionInHours(playerHabits.getSessionInHours());
        playerHabitsFound.setNocturnal(playerHabits.isNocturnal());
        playerHabitsFound.setHotBlooded(playerHabits.isHotBlooded());
        playerHabitsFound.setLeader(playerHabits.isLeader());
        playerHabitsFound.setPVE(playerHabits.isPVE());
        playerHabitsFound.setPVP(playerHabits.isPVP());

        return playerHabitsRepository.save(playerHabitsFound);
    }

    // delete

    public void deletePlayerHabitsById(Long id){
        playerHabitsRepository.deleteById(id);
    }
}
