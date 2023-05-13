package com.devnatao.menu.services;

import com.devnatao.menu.entities.Food;
import com.devnatao.menu.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {


    @Autowired
    private FoodRepository repository;

    @Transactional(readOnly = false)
    public Food create(Food food) {
        food.setId(null);
        return repository.save(food);
    }

    @Transactional(readOnly = false)
    public void delete(Long id) {
        Optional<Food> entity = repository.findById(id);
        repository.delete(entity.get());
    }

    @Transactional(readOnly = false)
    public Food update(Food food, Long id) {
        food.setId(id);
        return repository.save(food);
    }

    @Transactional(readOnly = true)
    public List<Food> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Food findById(Long id) {
        return repository.findById(id).get();
    }
}
