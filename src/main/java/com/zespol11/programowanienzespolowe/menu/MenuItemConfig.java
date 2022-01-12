package com.zespol11.programowanienzespolowe.menu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
public class MenuItemConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            MenuItemRepository menuItemRepository
    ){
        return args -> {

            MenuItem pesto = new MenuItem(
                    "czerwone pesto",
                    "zdjecie",
                    List.of("makaron", "czerwone pesto", "kurczak"),
                    Map.of("pomidory", 15.42F, "rukola", 0.50F),
                    15.32F
            );

            MenuItem  scrambledEggs= new MenuItem(
                    "jajecznica",
                    "zdjecie2",
                    List.of("jajka", "maslo"),
                    Map.of("szynka", 15.42F, "pieczarki", 0.50F),
                    20.32F
            );


            menuItemRepository.saveAll(
              List.of(pesto, scrambledEggs)
            );


        };
    }

}
