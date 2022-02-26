package com.zespol11.programowanienzespolowe.userRegistration;

import com.zespol11.programowanienzespolowe.order.orderMaster.OrderMasters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUser(){return userRepository.findAll();}

    public void addNewUser(User user){
////        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
//
//        if(userOptional.isPresent()){
//            throw new IllegalStateException("email taken");
//        }

        userRepository.save(user);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        addNewUser(new User(1L, "Andrzej"));
        addNewUser(new User(1L, "Jacek"));
        addNewUser(new User(1L, "Barbara"));
        addNewUser(new User(1L, "Małgorzata"));
        addNewUser(new User(1L, "Jerzy"));
        addNewUser(new User(1L, "Wiesław"));
    }

}
