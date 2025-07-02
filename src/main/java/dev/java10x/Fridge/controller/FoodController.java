package dev.java10x.Fridge.controller;

import dev.java10x.Fridge.model.Food;
import dev.java10x.Fridge.service.FoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("localhost/food")
public class FoodController {
    private final FoodService service;

    public FoodController(FoodService service) {
        this.service = service;
    }

    @GetMapping
    public List<Food> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Food create(@RequestBody Food request) {
        return service.save(request);
    }

    @DeleteMapping
    public void delete(Long id) {
        service.delete(id);
    }
}
