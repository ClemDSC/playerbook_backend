package com.playerbook.demo.domains.userGameInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usergameinfo")
public class UserGameInfoController {

    private final UserGameInfoService userGameInfoService;

    @Autowired
    public UserGameInfoController(UserGameInfoService userGameInfoService) {
        this.userGameInfoService = userGameInfoService;
    }

    // create
    @PostMapping("/add/{id}")
    public ResponseEntity<UserGameInfo> addUserGameInfo(@RequestBody UserGameInfo userGameInfo, @PathVariable("id") Long id){
        UserGameInfo newUserGameInfo = userGameInfoService.addUserGameInfo(userGameInfo, id);
        return new ResponseEntity<>(newUserGameInfo, HttpStatus.OK);
    }

    // read
    @GetMapping
    public ResponseEntity<List<UserGameInfo>> getAllUserGameInfos() {
        List<UserGameInfo> allUserGameInfos = userGameInfoService.findAllUserGameInfos();
        return new ResponseEntity<>(allUserGameInfos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserGameInfo> getOneUserGameInfo(@PathVariable("id") Long id) {
        UserGameInfo oneUserGameInfo = userGameInfoService.findUserGameInfoById(id);
        return new ResponseEntity<>(oneUserGameInfo, HttpStatus.OK);
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<UserGameInfo> updateUserGameInfo(@PathVariable("id") Long id, @RequestBody UserGameInfo userGameInfo) {
        UserGameInfo updatedUserGameInfo = userGameInfoService.updateUserGameInfoById(id, userGameInfo);
        return new ResponseEntity<>(updatedUserGameInfo, HttpStatus.OK);
    }

    // delete
    @DeleteMapping("/{id}")
    public void deleteUserGameInfo(@PathVariable("id") Long id){
        userGameInfoService.deleteUserGameInfoById(id);
        new ResponseEntity<>(HttpStatus.OK);
    }
}
