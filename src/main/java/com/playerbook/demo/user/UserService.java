package com.playerbook.demo.user;

import com.playerbook.demo.playerHabits.PlayerHabits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // create
    public User addUser(User user){
        System.out.println(user);
        return userRepository.save(user);
    }

    // read
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User findUserById(Long id){
        return userRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("sorry, id " + id + " not found")
        );
    }

    // update
    public User updateUserById(Long id, User user){
        User userFound = userRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("sorry, id " + id + " not found")
        );

        userFound.setName(user.getName());
        userFound.setLinkAvatar(user.getLinkAvatar());
        userFound.setCountry(user.getCountry());
        userFound.setBiography(user.getBiography());
        userFound.setPlayerHabits(user.getPlayerHabits());
        userFound.setUserBehavior(user.getUserBehavior());
        userFound.setGameList(user.getGameList());
        userFound.setUserGameInfo(user.getUserGameInfo());

        return userRepository.save(userFound);
    }

    // delete

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

}
