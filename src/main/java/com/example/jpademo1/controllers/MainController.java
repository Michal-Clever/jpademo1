package com.example.jpademo1.controllers;

import com.example.jpademo1.models.UserEntity;
import com.example.jpademo1.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    @ResponseBody
    public String index(){
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("ostatniaproba@wp.pl");
        userEntity.setUsername("ostatniaproba1045");
        userEntity.setPassword("ostatniaproba1");
     

        userRepository.save(userEntity);
        return "Zapisano!!!";
    }

}
