package com.example.StudySpringBoot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.StudySpringBoot.entity.Gammer;
import com.example.StudySpringBoot.service.GammerService;

@RestController
@RequestMapping("/gammers")
public class GammerController {
	@Autowired
    private GammerService gammerService;

    @GetMapping
    public List<Gammer> getAllGammers() {
        return gammerService.getAllGammers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gammer> getGammerById(@PathVariable Long id) {
        Optional<Gammer> gammer = gammerService.getGammerById(id);
        return gammer.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Gammer createGammer(@RequestBody Gammer gammer) {
        return gammerService.saveGammer(gammer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gammer> updateGammer(@PathVariable Long id, @RequestBody Gammer gammerDetails) {
        Gammer updatedGammer = gammerService.updateGammer(id, gammerDetails);
        if (updatedGammer != null) {
            return ResponseEntity.ok(updatedGammer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGammer(@PathVariable Long id) {
        gammerService.deleteGammer(id);
        return ResponseEntity.noContent().build();
    }
}
