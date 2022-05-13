package com.zespol11.programowanienzespolowe.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FoodItemService {

    private final FoodItemRepository foodItemRepository;

    @Autowired
    public FoodItemService(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    public List<FoodItem> getFoodItems(
            String type,
            Boolean typeAsc,
            Boolean typeDesc,
            Boolean priceAsc,
            Boolean priceDesc,
            Boolean nameAsc,
            Boolean nameDesc
    ) {

        if(type != null){
            return foodItemRepository.findAllByTypeEquals(type);
        }

        if(typeAsc!=null){
            return foodItemRepository.findAllByOrderByTypeAsc();
        }

        if(typeDesc!=null){
            return foodItemRepository.findAllByOrderByTypeDesc();
        }

        if(priceAsc!=null){
            return foodItemRepository.findAllByOrderByPriceAsc();
        }

        if(priceDesc!=null){
            return foodItemRepository.findAllByOrderByPriceDesc();
        }

        if(nameAsc!=null){
            return foodItemRepository.findAllByOrderByNameAsc();
        }

        if(nameDesc!=null){
            return foodItemRepository.findAllByOrderByNameDesc();
        }

        return foodItemRepository.findAll();
    }

    public void addNewFoodItem(FoodItem foodItem) {
        Optional<FoodItem> foodItemOptional = foodItemRepository
                .findFoodItemByName(foodItem.getName());

        if(foodItemOptional.isPresent()){
            throw new IllegalStateException("foodItem exists!");
        }

        foodItemRepository.save(foodItem);
    }

    public void deleteFoodItem(Long foodItemId) {
        boolean exist = foodItemRepository.existsById(foodItemId);

        if(!exist){
            throw new IllegalStateException("foodItem with id " + foodItemId + "does not exist");
        }

        foodItemRepository.deleteById(foodItemId);
    }

    @Transactional
    public void updateFoodItem(Long foodItemID,
                               String name,
                               Double price,
                               String type,
                               Boolean avaiable,
                               String yes) {

        FoodItem foodItem = foodItemRepository.findById(foodItemID)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id" + foodItemID + "does not exist"
                ));

        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(foodItem.getName(), name)
        ) {
            Optional<FoodItem> foodItemOptional = foodItemRepository
                    .findFoodItemByName(name);

            if (foodItemOptional.isPresent()) {
                throw new IllegalStateException("name taken");
            }

            foodItem.setName(name);

        }

        if (price != null &&
                !Objects.equals(foodItem.getPrice(), price)
        ) {
            foodItem.setPrice(price);
        }

        if (type != null &&
                type.length() > 0 &&
                !Objects.equals(foodItem.getType(), type)
        ) {

            foodItem.setType(type);

        }

        if(yes != null &&
                yes.length() > 0) {
            if (foodItem.getAvaiable() == true) {
                foodItem.setAvaiable(false);
            } else foodItem.setAvaiable(true);
        }

    }

    public FoodItem getFoodItemById(Long foodItemId) {
       FoodItem foodItem = foodItemRepository.findById(foodItemId)
               .orElseThrow(() -> new IllegalStateException(
                       "foodItem with id " + foodItemId + " does not exist"
               ));

       return foodItem;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        addNewFoodItem(new FoodItem(1L,"Żeberka w sosie BBQ", 45.00, "dania-glowne", true));
        addNewFoodItem(new FoodItem(2L,"Żeberka w sosie ostrym", 45.00, "dania-glowne", true));
        addNewFoodItem(new FoodItem(3L,"Hamburger (wołowina w sosie słodko kwaśnym)", 39.99, "dania-glowne", true));
        addNewFoodItem(new FoodItem(4L,"Hamburger (wołowina, pieczrki i ser w sosie 1000 wysp) ", 39.90, "dania-glowne", true));
        addNewFoodItem(new FoodItem(5L,"Pizza peperoni", 33.90, "dania-glowne", true));
        addNewFoodItem(new FoodItem(6L,"Coca-Cola 0.5l", 6.90, "napoje", true));
        addNewFoodItem(new FoodItem(7L,"Sprite 0.5l", 6.90, "napoje", true));
        addNewFoodItem(new FoodItem(8L,"Fanta 0.5l", 6.90, "napoje", true));
        addNewFoodItem(new FoodItem(9L,"Herbata", 6.00, "napoje", true));
        addNewFoodItem(new FoodItem(10L,"Kawa czarna", 7.00, "napoje", true));
        addNewFoodItem(new FoodItem(11L,"Kawa z mlekiem", 7.50, "napoje", true));
        addNewFoodItem(new FoodItem(12L,"Cappuccino", 9.00, "napoje", true));
        addNewFoodItem(new FoodItem(13L,"Woda niegazowana 0.5l", 5.00, "napoje", true));
        addNewFoodItem(new FoodItem(14L,"Woda gazowana 0.5l", 6.00, "napoje", true));
        addNewFoodItem(new FoodItem(15L,"Pizza hawajska", 33.90, "dania-glowne", true));
        addNewFoodItem(new FoodItem(16L,"Pizza salami", 33.90, "dania-glowne", true));
        addNewFoodItem(new FoodItem(17L,"Lody czekoladowe", 6.99, "desery", true));
        addNewFoodItem(new FoodItem(18L,"Lody truskawkowe", 6.99, "desery", true));
        addNewFoodItem(new FoodItem(19L,"Lody śmietankowe", 4.99, "desery", true));
        addNewFoodItem(new FoodItem(20L,"Lody pistacjowe", 6.99, "desery", true));
        addNewFoodItem(new FoodItem(21L,"Sernik", 5.99, "desery", true));
        addNewFoodItem(new FoodItem(22L,"Ekler", 5.99, "desery", true));
        addNewFoodItem(new FoodItem(23L,"Kostka królewska", 5.99, "desery", true));
        addNewFoodItem(new FoodItem(24L,"Sałatka grecka", 15.00, "salatki", true));
        addNewFoodItem(new FoodItem(25L,"Sałatka z tuńczykiem", 15.00, "salatki", true));
        addNewFoodItem(new FoodItem(26L,"Sałatka gyros", 15.00, "salatki", true));
        addNewFoodItem(new FoodItem(27L,"Sałatka z jajkiem", 15.00, "salatki", true));
        addNewFoodItem(new FoodItem(28L,"Rosół", 8.00, "zupy", true));
        addNewFoodItem(new FoodItem(29L,"Żurek", 8.00, "zupy", true));
        addNewFoodItem(new FoodItem(30L,"Barszcz czerwony", 8.00, "zupy", true));
        addNewFoodItem(new FoodItem(31L,"Barszcz biały", 8.00, "zupy", true));
        addNewFoodItem(new FoodItem(32L,"Jajecznica", 9.00, "sniadania", true));
        addNewFoodItem(new FoodItem(33L,"Jajecznica z bekonem", 10.00, "sniadania", true));
        addNewFoodItem(new FoodItem(34L,"Jajecznica z boczkiem", 10.00, "sniadania", true));
        addNewFoodItem(new FoodItem(35L,"Nalesnik z czkoladą", 7.00, "sniadania", true));
        addNewFoodItem(new FoodItem(36L,"Naleśnik z truskawką", 7.00, "sniadania", true));
        addNewFoodItem(new FoodItem(37L,"Croissant maślany", 5.00, "sniadania", true));
        addNewFoodItem(new FoodItem(38L,"Croissant z czekoladą", 7.00, "sniadania", true));




    }

}
