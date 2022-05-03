package com.zespol11.programowanienzespolowe.food;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
class FoodItemServiceTest {

    @Autowired
    private FoodItemRepository repository;
    @Autowired
    private FoodItemService service;

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    void getFoodItems() {
        //given
        List<FoodItem> foodItems = List.of(
                new FoodItem(
                        5L,
                        "jajka po benedyktynsku",
                        15.24,
                        "sniadanie",
                        true),
                new FoodItem(
                        6L,
                        "kotlet schabowy po arabsku",
                        22.24,
                        "obiad",
                        false),
                new FoodItem(
                        7L,
                        "paluchy serowe",
                        44.24,
                        "przystawka",
                        true)
                );
            repository.saveAll(foodItems);

            //when
            List<FoodItem> type = service.getFoodItems("obiad",
                    null,
                    null,
                    null,
                    null,
                    null,
                    null);

            //then
            assertEquals(1, type.size());

    }
}