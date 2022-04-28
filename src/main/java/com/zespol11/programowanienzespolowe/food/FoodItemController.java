package com.zespol11.programowanienzespolowe.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
@CrossOrigin
public class FoodItemController {

    private final FoodItemService foodItemService;

    @Autowired
    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    @GetMapping
    public List<FoodItem> getFoodItems(
            @RequestParam(required = false, name = "type") String type,
            @RequestParam(required = false, name = "type-asc") Boolean typeAsc,
            @RequestParam(required = false, name = "type-desc") Boolean typeDesc,
            @RequestParam(required = false, name = "price-asc") Boolean priceAsc,
            @RequestParam(required = false, name = "price-desc") Boolean priceDesc,
            @RequestParam(required = false, name = "name-asc") Boolean nameAsc,
            @RequestParam(required = false, name = "name-desc") Boolean nameDesc){
        return foodItemService.getFoodItems(
                type,
                typeAsc,
                typeDesc,
                priceAsc,
                priceDesc,
                nameAsc,
                nameDesc
        );
    }

    @GetMapping(path = "{foodItemId}")
    public FoodItem getFoodItemById(@PathVariable Long foodItemId){
        return foodItemService.getFoodItemById(foodItemId);
    }

    @PostMapping
    public void addNewFoodItem(@RequestBody FoodItem foodItem){
        foodItemService.addNewFoodItem(foodItem);
    }

    @DeleteMapping(path = "{foodItemId}")
    public void deleteFoodItem(@PathVariable("foodItemId") Long foodItemId){
        foodItemService.deleteFoodItem(foodItemId);
    }

    @PutMapping(path = "{foodItemId}")
    public void updateFoodItem(
            @PathVariable("foodItemId") Long foodItemId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double price){
        foodItemService.updateFoodItem(foodItemId, name, price);
    }


}
