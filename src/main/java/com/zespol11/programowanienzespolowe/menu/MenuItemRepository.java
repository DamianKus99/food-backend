package com.zespol11.programowanienzespolowe.menu;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

    @Query("SELECT m FROM MenuItem m WHERE m.name = ?1")
    Optional<MenuItem> findMenuItemByName(String name);

    void deleteByName(String name);
}
