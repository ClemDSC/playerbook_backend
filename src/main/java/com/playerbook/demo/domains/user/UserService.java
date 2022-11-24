package com.playerbook.demo.domains.user;

import com.playerbook.demo.domains.role.Role;
import com.playerbook.demo.domains.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    // login / auth
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser appUserAlreadyExists = userRepository.findByUsername(username);

        if (appUserAlreadyExists == null) {
            System.out.println("L'utilisateur n'existe pas.");
            throw new UsernameNotFoundException("User doesn't exist");
        } else {
            System.out.println("L'utilisateur " + username + " a été trouvé.");
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        appUserAlreadyExists.getRoleList().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new User(appUserAlreadyExists.getUsername(), appUserAlreadyExists.getPassword(), authorities);
    }

    // create / register
    public AppUser addUser(AppUser appUser) throws Exception {
        AppUser appUserAlreadyExists = userRepository.findByUsername(appUser.getUsername());
        if(appUserAlreadyExists == null){
            System.out.println("Utilisateur " + appUser.getUsername() + " sauvegardé dans la BDD.");
            appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
            return userRepository.save(appUser);
        } else {
            System.out.println("Le pseudo " + appUser.getUsername() + " est déjà utilisé.");
            throw new Exception("Username already taken");
        }

    }

    // read
    public List<AppUser> findAllUsers(){
        return userRepository.findAll();
    }

    public AppUser findUserById(Long id){
        return userRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("sorry, id " + id + " not found")
        );
    }

    // update
    public AppUser updateUserById(Long id, AppUser appUser){
        AppUser appUserFound = userRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("sorry, id " + id + " not found")
        );

        appUserFound.setUsername(appUser.getUsername());
        appUserFound.setPassword(appUser.getPassword());
        appUserFound.setLinkAvatar(appUser.getLinkAvatar());
        appUserFound.setCountry(appUser.getCountry());
        appUserFound.setBiography(appUser.getBiography());
        appUserFound.setPlayerHabits(appUser.getPlayerHabits());
        appUserFound.setUserBehavior(appUser.getUserBehavior());
        appUserFound.setGameList(appUser.getGameList());
        appUserFound.setUserGameInfo(appUser.getUserGameInfo());

        return userRepository.save(appUserFound);
    }

    // delete

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

    public void addRoleToUser(String username, String roleName) throws Exception {
        AppUser appUserAlreadyExists = userRepository.findByUsername(username);
        if(appUserAlreadyExists == null){
            throw new Exception("Username already taken");
        } else {
            Role role = roleRepository.findByName(roleName);
            appUserAlreadyExists.getRoleList().add(role);
            userRepository.save(appUserAlreadyExists);
        }
    }

}
