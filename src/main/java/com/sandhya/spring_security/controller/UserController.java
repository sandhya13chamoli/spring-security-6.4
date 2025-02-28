package com.sandhya.spring_security.controller;

import com.sandhya.spring_security.domain.entity.UserInfo;
import com.sandhya.spring_security.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserInfo> createUser(@RequestBody UserInfo userInfo) {
        return new ResponseEntity<>(userInfoService.createUser(userInfo), HttpStatus.OK);
    }
}
