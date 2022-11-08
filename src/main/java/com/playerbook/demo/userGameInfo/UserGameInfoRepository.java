package com.playerbook.demo.userGameInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGameInfoRepository extends JpaRepository<UserGameInfo, Long> {
}
