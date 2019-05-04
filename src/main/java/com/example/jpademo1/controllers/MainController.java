package com.example.jpademo1.controllers;

import com.example.jpademo1.models.UserEntity;
import com.example.jpademo1.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;

//zapisuje w bazie uzytkownika
//    @GetMapping("/")
//    @ResponseBody
//    public String index(){
//        UserEntity userEntity = new UserEntity();
//        userEntity.setEmail("remoncik@wp.pl");
//        userEntity.setUsername("remoncik1721");
//        userEntity.setPassword("remoncik");
//
//
//        userRepository.save(userEntity);
//        return "Zapisano!!!1721";
//    }

    //pobiera użytkownika z bazy
    @GetMapping("/")
    @ResponseBody
    public String index() {
        // jedego użytkownika po ID
         Optional<UserEntity> downData = userRepository.findById(10);
     //   wywala błąd przy braku id
         return downData.orElseThrow(IllegalStateException::new).toString();


    }

}
