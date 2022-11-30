package com.playerbook.demo.domains.userGameInfo;

import com.playerbook.demo.domains.game.Game;
import com.playerbook.demo.domains.game.GameRepository;
import com.playerbook.demo.domains.user.AppUser;
import com.playerbook.demo.domains.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGameInfoService {

    private final UserGameInfoRepository userGameInfoRepository;
    private final GameRepository gameRepository;
    private final UserRepository userRepository;


    @Autowired
    public UserGameInfoService(UserGameInfoRepository userGameInfoRepository, GameRepository gameRepository, com.playerbook.demo.domains.user.UserRepository userRepository) {
        this.userGameInfoRepository = userGameInfoRepository;
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
    }




    // create
    public UserGameInfo addUserGameInfo(UserGameInfo userGameInfo, Long gameId, Long appUserId) {
        Game gameFound = gameRepository.findById(gameId).orElseThrow(
                () -> new IllegalStateException("sorry, id " + gameId + " not found")
        );
        AppUser appUserFound = userRepository.findById(appUserId).orElseThrow(
                () -> new IllegalStateException("sorry, id " + appUserId + " not found")
        );
        userGameInfo.setGame(gameFound);
        userGameInfo.setAppUser(appUserFound);
        return userGameInfoRepository.save(userGameInfo);
    }

    // read
    public List<UserGameInfo> findAllUserGameInfos(){
        return userGameInfoRepository.findAll();
    }

    public UserGameInfo findUserGameInfoById(Long id){
        return userGameInfoRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("sorry, id " + id + " not found")
        );
    }

    // update
    public UserGameInfo updateUserGameInfoById(Long id, UserGameInfo userGameInfo){
        UserGameInfo userGameInfoFound = userGameInfoRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("sorry, id " + id + " not found")
        );

        userGameInfoFound.setUserPseudo(userGameInfo.getUserPseudo());
        userGameInfoFound.setGuild(userGameInfo.getGuild());
        userGameInfoFound.setLevel(userGameInfo.getLevel());
        userGameInfoFound.setPilouRank(userGameInfo.getPilouRank());
        userGameInfoFound.setDifficulty(userGameInfo.getDifficulty());
        userGameInfoFound.setServerName(userGameInfoFound.getServerName());

        return userGameInfoRepository.save(userGameInfoFound);
    }

    // delete

    public void deleteUserGameInfoById(Long id){
        userGameInfoRepository.deleteById(id);
    }

}
