package com.example.jpademo1.controllers;

import com.example.jpademo1.models.UserEntity;
import com.example.jpademo1.models.repositories.UserRepository;
import com.example.jpademo1.models.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

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
   // @ResponseBody
    public String index(Model model) {
//        // jedego użytkownika po ID
//        Optional<UserEntity> downData = userRepository.findById(10);
//        //   wywala błąd przy braku id
//        return downData.toString();
        model.addAttribute("user", userService);
        return "index";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }


    @PostMapping("/register")
    //  @ResponseBody
    public String register(@RequestParam("login") String login,
                           @RequestParam("password") String password,
                           @RequestParam("passwordReapet") String passwordReapet,
                           @RequestParam("email") String email,
                           Model model) {
        if (!password.equals(passwordReapet)) {
            //  return "Hasła nie są takie same";
            model.addAttribute("info", "Hasła się nie zgadzają!");
            return "register";
        }

        //sprawdza czy nick nie jest zajety
        if (userRepository.existsByUsername(login)) {
            model.addAttribute("info", "Nick zajety");
            return "register";
        }

        // dodaje rejestracje do bazy
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword(password);
        userEntity.setEmail(email);
        userEntity.setUsername(login);

        userRepository.save(userEntity);

        //return "Konto utworzone";
        model.addAttribute("info", "Zarejestrowano :D");
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("login") String login,
                        @RequestParam("password") String password,
                        Model model) {
        Optional<UserEntity> user = userRepository.findByUsernameAndPassword(login, password);

        if (user.isPresent()) {
            userService.setLogin(true);
            userService.setUser(user.get());
            return "redirect:/";
        }

        model.addAttribute("info", "Błędne dane!");
        return "login";

    }
}
