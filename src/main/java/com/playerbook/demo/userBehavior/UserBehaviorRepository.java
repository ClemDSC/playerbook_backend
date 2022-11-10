package com.playerbook.demo.userBehavior;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBehaviorRepository extends JpaRepository<UserBehavior, Long> {
}
