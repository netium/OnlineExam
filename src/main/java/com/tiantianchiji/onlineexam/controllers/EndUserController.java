package com.tiantianchiji.onlineexam.controllers;

import com.tiantianchiji.onlineexam.dtos.JsonResponse;
import com.tiantianchiji.onlineexam.dtos.UserCredential;
import com.tiantianchiji.onlineexam.dtos.UserProfile;
import com.tiantianchiji.onlineexam.entities.UserEntity;
import com.tiantianchiji.onlineexam.services.EndUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class EndUserController {
    @Autowired
    EndUserService _service;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public JsonResponse<UserProfile> getUserProfile(@PathVariable Long id, @RequestParam(value = "userToken", defaultValue = "")String userToken) {
        JsonResponse<UserProfile> response = new JsonResponse<>();
        response.setByHttpStatus(HttpStatus.OK);
        response.setMessage("");
        UserEntity user = _service.getUserProfile(userToken, id);
        if (user == null) {
            response.setByHttpStatus(HttpStatus.NOT_FOUND);
            response.setMessage("UserId: " + id.toString() + "was not found");
            response.setBody(null);
        }
        else {
            response.setByHttpStatus(HttpStatus.OK);
            response.setMessage("");
            response.setBody(UserProfile.fromEntity(user));
        }
        return response;
    }

    @RequestMapping(method = RequestMethod.POST)
    public long createUser(@RequestBody UserCredential userCredential) {
        long id = _service.createUser(userCredential.getUsername(), userCredential.getPassword());
        return id;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public JsonResponse<String> login(@RequestBody UserCredential userCredential) {
        String token = _service.login(userCredential.getUsername(), userCredential.getPassword());
        if (token == null || token.length() == 0) {
            return new JsonResponse<String>().fillStatus(HttpStatus.FORBIDDEN).fillMessage("Login failed!").fillBody("");
        }
        else {
            return new JsonResponse<String>().fillStatus(HttpStatus.CREATED).fillMessage("Login succeed!").fillBody(token);
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.PUT)
    public JsonResponse<String> logout(@RequestParam(value="userToken")String userToken) {
        _service.logout(userToken);
        return new JsonResponse<String>().fillStatus(HttpStatus.NO_CONTENT).fillMessage("Logout success!").fillBody("");
    }
}
