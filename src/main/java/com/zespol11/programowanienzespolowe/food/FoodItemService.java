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
        addNewFoodItem(new FoodItem(1L,"Gnochi ze szpinakiem i pomidorami suszonymi", 33.90, "dania-glowne", true));
        addNewFoodItem(new FoodItem(2L,"Pieczone żeberka w pikantnej marynacie", 42.90, "sniadania", false));
        addNewFoodItem(new FoodItem(3L,"Paluchy z parmezanem i sosem pikantnym", 24.90, "dania-glowne", true));
        addNewFoodItem(new FoodItem(4L,"Lody", 37.90, "desery", true));
        addNewFoodItem(new FoodItem(5L,"Sałatka grecka", 38.90, "salatki", true));
        addNewFoodItem(new FoodItem(6L,"Cola", 37.90, "napoje", true));
    }

}
