package com.playerbook.demo.domains.userGameInfo;

import com.playerbook.demo.domains.game.Game;
import com.playerbook.demo.domains.game.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGameInfoService {

    private final UserGameInfoRepository userGameInfoRepository;
    private final GameRepository gameRepository;

    @Autowired
    public UserGameInfoService(UserGameInfoRepository userGameInfoRepository, GameRepository gameRepository) {
        this.userGameInfoRepository = userGameInfoRepository;
        this.gameRepository = gameRepository;
    }


    // create
    public UserGameInfo addUserGameInfo(UserGameInfo userGameInfo, Long id) {
        Game gameFound = gameRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("sorry, id " + id + " not found")
        );
        userGameInfo.setGame(gameFound);
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
