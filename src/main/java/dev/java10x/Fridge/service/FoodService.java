package dev.java10x.Fridge.service;

import dev.java10x.Fridge.model.Food;
import dev.java10x.Fridge.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    private final FoodRepository repository;

    public FoodService(FoodRepository repository) {
        this.repository = repository;
    }

    public List<Food> getAll(){return repository.findAll();}
    public Food save(Food food){return repository.save(food);}
    public void delete(Long id){repository.deleteById(id);}
}
