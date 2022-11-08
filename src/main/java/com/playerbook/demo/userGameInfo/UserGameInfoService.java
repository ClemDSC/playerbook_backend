package com.playerbook.demo.userGameInfo;

import com.playerbook.demo.userBehavior.UserBehavior;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGameInfoService {

    private final UserGameInfoRepository userGameInfoRepository;

    @Autowired
    public UserGameInfoService(UserGameInfoRepository userGameInfoRepository) {
        this.userGameInfoRepository = userGameInfoRepository;
    }

    // create
    public UserGameInfo addUserGameInfo(UserGameInfo userGameInfo){
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
        userGameInfoFound.setRank(userGameInfo.getRank());
        userGameInfoFound.setDifficulty(userGameInfo.getDifficulty());
        userGameInfoFound.setServerName(userGameInfoFound.getServerName());

        return userGameInfoRepository.save(userGameInfoFound);
    }

    // delete

    public void deleteUserGameInfoById(Long id){
        userGameInfoRepository.deleteById(id);
    }

}
