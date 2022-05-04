package com.zespol11.programowanienzespolowe.userRegistration.appuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUser();
    }

    @PostMapping("/registration")
    public ResponseEntity<String> registerUser(@RequestBody User user){

        userService.addNewUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body("User registered");
    }

    @GetMapping("/log-in")
    public ResponseEntity<User> logIn(@RequestParam String email,
                                        @RequestParam String password){

        User user = userService.checkPassword(email, password);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }



}
