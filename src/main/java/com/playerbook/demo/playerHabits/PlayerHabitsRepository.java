package com.playerbook.demo.playerHabits;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerHabitsRepository extends JpaRepository<PlayerHabits, Long> {
}
