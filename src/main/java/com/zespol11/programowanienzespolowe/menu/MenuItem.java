package com.zespol11.programowanienzespolowe.menu;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table
public class MenuItem {

    @Id
    @SequenceGenerator(
            name = "menuitem_sequence",
            sequenceName = "menutiem_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "menuitem_sequence"
    )
    private Long id;

    private String name;
    private String itemImageLink;
    @ElementCollection
    private List<String> ingredients = new ArrayList<>();
    @ElementCollection
    private Map<String, Float> additions = new HashMap<>();
    private Float price;

    public MenuItem(String name, String itemImageLink, List<String> ingredients, Map<String, Float> additions, Float price) {
        this.name = name;
        this.itemImageLink = itemImageLink;
        this.ingredients = ingredients;
        this.additions = additions;
        this.price = price;
    }

    public MenuItem() {

    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemImageLink() {
        return itemImageLink;
    }

    public void setItemImageLink(String itemImageLink) {
        this.itemImageLink = itemImageLink;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public Map<String, Float> getAdditions() {
        return additions;
    }

    public void setAdditions(Map<String, Float> additions) {
        this.additions = additions;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", itemImageLink='" + itemImageLink + '\'' +
                ", ingredients=" + ingredients +
                ", additions=" + additions +
                ", price=" + price +
                '}';
    }
}
