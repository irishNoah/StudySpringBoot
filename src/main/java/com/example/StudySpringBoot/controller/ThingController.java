package com.example.StudySpringBoot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.StudySpringBoot.entity.Thing;
import com.example.StudySpringBoot.service.ThingService;

@RestController
@RequestMapping("/things")
public class ThingController {

    @Autowired
    private ThingService thingService;

    @GetMapping
    public List<Thing> getAllThings() {
        return thingService.findAllThings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Thing> getThingById(@PathVariable Long id) {
        Thing thing = thingService.findThingById(id);
        if (thing != null) {
            return ResponseEntity.ok(thing);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Thing createThing(@RequestBody Thing thing) {
        return thingService.saveThing(thing);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Thing> updateThing(@PathVariable Long id, @RequestBody Thing thingDetails) {
        Thing thing = thingService.findThingById(id);
        if (thing != null) {
            thing.setName(thingDetails.getName());
            thing.setPrice(thingDetails.getPrice());
            Thing updatedThing = thingService.updateThing(thing);
            return ResponseEntity.ok(updatedThing);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteThing(@PathVariable Long id) {
        thingService.deleteThing(id);
        return ResponseEntity.noContent().build();
    }
}
