package com.tiantianchiji.onlineexam.controllers;

import com.tiantianchiji.onlineexam.dtos.JsonResponse;
import com.tiantianchiji.onlineexam.dtos.UserProfile;
import com.tiantianchiji.onlineexam.entities.UserEntity;
import com.tiantianchiji.onlineexam.services.EndUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class EndUserController {
    @Autowired
    EndUserService _service;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public JsonResponse<UserProfile> getUserProfile(@PathVariable Long id, @RequestParam(value = "userToken", defaultValue = "")String userToken) {
        JsonResponse<UserProfile> response = new JsonResponse<>();
        response.setStatus(HttpStatus.OK);
        response.setMessage("");
        UserEntity user = _service.getUserProfile(userToken, id);
        if (user == null) {
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setMessage("UserId: " + id.toString() + "was not found");
            response.setBody(null);
        }
        else {
            response.setStatus(HttpStatus.OK);
            response.setMessage("");
            response.setBody(UserProfile.fromEntity(user));
        }
        return response;
    }

    @RequestMapping(method = RequestMethod.POST)
    public long createUser(@RequestParam(value="username")String username, @RequestParam(value="password")String password) {
        long id = _service.createUser(username, password);
        return id;
    }

    @RequestMapping(value = "{id}/login", method = RequestMethod.POST)
    public String login(@RequestParam(value="username")String username, @RequestParam(value="password")String password) {
        String token = _service.login(username, password);
        return token;
    }

    @RequestMapping(value = "{id}/logoff", method = RequestMethod.PUT)
    public void logout(@RequestParam(value="userToken")String userToken) {

    }
}
