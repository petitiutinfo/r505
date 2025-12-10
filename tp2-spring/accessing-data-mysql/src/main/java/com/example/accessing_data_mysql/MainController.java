package com.example.accessing_data_mysql;;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/demo")
public class MainController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "API OK - utilisez /demo/add ou /demo/all";
    }

    @GetMapping(path="/add")
    public @ResponseBody String addNewUser() {
        User n = new User();
        n.setName("Test");
        n.setEmail("test@test.com");
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}