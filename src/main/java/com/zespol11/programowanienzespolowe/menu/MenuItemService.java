package com.zespol11.programowanienzespolowe.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public class MenuItemService {

//    private final MenuItemRepository menuItemRepository;
//
//    @Autowired
//    public MenuItemService(MenuItemRepository menuItemRepository) {
//        this.menuItemRepository = menuItemRepository;
//    }
//
//    public List<MenuItem> getMenuItem(){
//        return menuItemRepository.findAll();
//    }
//
//    public void addNewMenuItem(MenuItem menuItem){
//        Optional<MenuItem> menuItemOptional = menuItemRepository.findMenuItemByName(menuItem.getName());
//
//        if(menuItemOptional.isPresent()){
//            throw new IllegalStateException();
//        }
//
//        menuItemRepository.save(menuItem);
//
//    }
//
//    public void deleteMenuItem(String name){
//
//       Optional<MenuItem> menuItemOptional = menuItemRepository.findMenuItemByName(name);
//
//       if(!menuItemOptional.isPresent()){
//           throw new IllegalStateException();
//       }
//
//        menuItemRepository.delete(menuItemOptional.get());
//    }
//
//    public void updateMenuItem(String newName, List<String> ingredients, List<String> additions, Float price) {
//
//
//    }
}
