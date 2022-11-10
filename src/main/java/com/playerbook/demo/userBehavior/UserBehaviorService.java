package com.playerbook.demo.userBehavior;

import com.playerbook.demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBehaviorService {

private final UserBehaviorRepository userBehaviorRepository;

    @Autowired
    public UserBehaviorService(UserBehaviorRepository userBehaviorRepository) {
        this.userBehaviorRepository = userBehaviorRepository;
    }

    // create
    public UserBehavior addUserBehavior(UserBehavior userBehavior){
        return userBehaviorRepository.save(userBehavior);
    }

    // read
    public List<UserBehavior> findAllUserBehaviors(){
        return userBehaviorRepository.findAll();
    }

    public UserBehavior findUserBehaviorById(Long id){
        return userBehaviorRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("sorry, id " + id + " not found")
        );
    }

    // update
    public UserBehavior updateUserBehaviorById(Long id, UserBehavior userBehavior){
        UserBehavior userBehaviorFound = userBehaviorRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("sorry, id " + id + " not found")
        );

        userBehaviorFound.setCasual(userBehavior.isCasual());
        userBehaviorFound.setProactive(userBehavior.isProactive());
        userBehaviorFound.setExtravert(userBehavior.isExtravert());
        userBehaviorFound.setPro(userBehavior.isPro());
        userBehaviorFound.setEmployeer(userBehavior.getEmployeer());

        return userBehaviorRepository.save(userBehaviorFound);
    }

    // delete

    public void deleteUserBehaviorById(Long id){
        userBehaviorRepository.deleteById(id);
    }

}
