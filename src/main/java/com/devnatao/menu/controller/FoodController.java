package com.devnatao.menu.controller;

import com.devnatao.menu.entities.Food;
import com.devnatao.menu.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService service;

    @PostMapping
    public ResponseEntity<Food> create(@RequestBody Food food) {
        return new ResponseEntity<>(service.create(food), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Food> update(@RequestBody Food food, @PathVariable Long id) {
        return new ResponseEntity<>(service.update(food, id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Food>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Food> findById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }
}
