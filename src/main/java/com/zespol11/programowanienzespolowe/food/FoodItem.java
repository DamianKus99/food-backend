package com.zespol11.programowanienzespolowe.food;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long foodItemId;

    private String name;

    private Double price;

    private String type;

    private Boolean avaiable;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodItem foodItem = (FoodItem) o;
        return Objects.equals(foodItemId, foodItem.foodItemId) && Objects.equals(name, foodItem.name) && Objects.equals(price, foodItem.price) && Objects.equals(type, foodItem.type) && Objects.equals(avaiable, foodItem.avaiable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foodItemId, name, price, type, avaiable);
    }
}
