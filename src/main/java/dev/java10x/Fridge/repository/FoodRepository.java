package dev.java10x.Fridge.repository;

import dev.java10x.Fridge.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {

}
