package com.playerbook.demo.domains.user;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // create
    @PostMapping("/add")
    public ResponseEntity<AppUser> addUser(@RequestBody AppUser appUser) throws Exception{
        AppUser newAppUser = userService.addUser(appUser);
        return new ResponseEntity<>(newAppUser, HttpStatus.CREATED);
    }

    @PostMapping("/add-role")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserform form) throws Exception{
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // read
    @GetMapping
    public ResponseEntity<List<AppUser>> getAllUser() {
        List<AppUser> allAppUsers = userService.findAllUsers();
        return new ResponseEntity<>(allAppUsers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getOneUser(@PathVariable("id") Long id) {
        AppUser oneAppUser = userService.findUserById(id);
        return new ResponseEntity<>(oneAppUser, HttpStatus.OK);
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<AppUser> updateUser(@PathVariable("id") Long id, @RequestBody AppUser appUser) {
        AppUser updatedAppUser = userService.updateUserById(id, appUser);
        return new ResponseEntity<>(updatedAppUser, HttpStatus.OK);
    }

    // delete
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUserById(id);
        new ResponseEntity<>(HttpStatus.OK);
    }
}

@Data
class RoleToUserform{
    private String username;
    private String roleName;
}