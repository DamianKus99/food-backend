package com.zespol11.programowanienzespolowe.userRegistration.appuser;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UserService {

    private final static String USER_NOT_FOUND_MSG = "appuser with email %s not found";
    private final UserRepository appUserRepository;
    private final UserRepository userRepository;

    public List<User> getUser(){return appUserRepository.findAll();}

    public void addNewUser(User user){
     Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());

        if(userOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }

        userRepository.save(user);
    }

    public User checkPassword(String email, String password){
        Optional<User> userOptional = userRepository.findUserByEmail(email);

        if(userOptional.isEmpty()){
            throw new IllegalStateException("wrongemail");
        }

        if(userOptional.get().getPassword().equals(password)){
            return userOptional.get();
        }

        throw new IllegalStateException("wrong password");
    }


    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
            addNewUser(new User(6L,"Kowalski","asasasassa","asjkasjksajkas",UserRole.USER));
            addNewUser(new User(6L,"Kowalski","admin@gmail.com","admin",UserRole.ADMIN));
            addNewUser(new User(6L,"Kowal","kucharz@gmail.com","kucharz",UserRole.COOK));
    }
}