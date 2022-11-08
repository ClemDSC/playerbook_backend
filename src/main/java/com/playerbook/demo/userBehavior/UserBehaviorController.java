package com.playerbook.demo.userBehavior;

import com.playerbook.demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userbehavior")
public class UserBehaviorController {

    private final UserBehaviorService userBehaviorService;

    @Autowired
    public UserBehaviorController(UserBehaviorService userBehaviorService) {
        this.userBehaviorService = userBehaviorService;
    }

    // create
    @PostMapping("/add")
    public ResponseEntity<UserBehavior> addUserBehavior(@RequestBody UserBehavior userBehavior){
        UserBehavior newUserBehavior = userBehaviorService.addUserBehavior(userBehavior);
        return new ResponseEntity<>(newUserBehavior, HttpStatus.OK);
    }

    // read
    @GetMapping
    public ResponseEntity<List<UserBehavior>> getAllUserBehavior() {
        List<UserBehavior> allUserBehaviors = userBehaviorService.findAllUserBehaviors();
        return new ResponseEntity<>(allUserBehaviors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserBehavior> getOneUserBehavior(@PathVariable("id") Long id) {
        UserBehavior oneUserBehavior = userBehaviorService.findUserBehaviorById(id);
        return new ResponseEntity<>(oneUserBehavior, HttpStatus.OK);
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<UserBehavior> updateUserBehavior(@PathVariable("id") Long id, @RequestBody UserBehavior userBehavior) {
        UserBehavior updatedUserBehavior = userBehaviorService.updateUserBehaviorById(id, userBehavior);
        return new ResponseEntity<>(updatedUserBehavior, HttpStatus.OK);
    }

    // delete
    @DeleteMapping("/{id}")
    public void deleteUserBehavior(@PathVariable("id") Long id){
        userBehaviorService.deleteUserBehaviorById(id);
        new ResponseEntity<>(HttpStatus.OK);
    }
}
