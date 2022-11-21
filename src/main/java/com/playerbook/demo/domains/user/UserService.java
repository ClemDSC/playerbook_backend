package com.playerbook.demo.domains.user;

import com.playerbook.demo.domains.role.Role;
import com.playerbook.demo.domains.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    // create
    public User addUser(User user) throws Exception {
        User userAlreadyExists = userRepository.findByUsername(user.getUsername());
        if(userAlreadyExists == null){
            System.out.println("Utilisateur " + user.getUsername() + " sauvegardé dans la BDD.");
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        } else {
            System.out.println("Le pseudo " + user.getUsername() + " est déjà utilisé.");
            throw new Exception("Username already taken");
        }

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

        userFound.setUsername(user.getUsername());
        userFound.setPassword(user.getPassword());
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

    public void addRoleToUser(String username, String roleName) throws Exception {
        User userAlreadyExists = userRepository.findByUsername(username);
        if(userAlreadyExists == null){
            throw new Exception("Username already taken");
        } else {
            Role role = roleRepository.findByName(roleName);
            userAlreadyExists.getRoleList().add(role);
            userRepository.save(userAlreadyExists);
        }
    }

}
