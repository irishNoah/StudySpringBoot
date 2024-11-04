package com.example.StudySpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.StudySpringBoot.entity.Cook;
import com.example.StudySpringBoot.service.CookService;

@RestController
@RequestMapping("/cooks")
public class CookController {

	@Autowired
    private CookService cookService;

    // Create
    @PostMapping
    public Cook createCook(@RequestBody Cook cook) {
        return cookService.saveThing(cook);
    }

    // Read all
    @GetMapping
    public List<Cook> getAllCooks() {
        return cookService.findAllCooks();
    }

    // Read one by ID
    @GetMapping("/{id}")
    public ResponseEntity<Cook> getCookById(@PathVariable Long id) {
        Cook cook = cookService.findCookById(id);
        if (cook != null) {
            return ResponseEntity.ok(cook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Cook> updateCook(@PathVariable Long id, @RequestBody Cook cookDetails) {
        Cook updatedCook = cookService.updateCook(id, cookDetails);
        if (updatedCook != null) {
            return ResponseEntity.ok(updatedCook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCook(@PathVariable Long id) {
        cookService.deleteCook(id);
        return ResponseEntity.noContent().build();
    }
}
