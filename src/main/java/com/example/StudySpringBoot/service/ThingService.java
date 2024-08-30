package com.example.StudySpringBoot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.StudySpringBoot.entity.Thing;

@Service
public abstract class ThingService<T extends Thing> {

    @Autowired
    private JpaRepository<T, Long> repository;

    @Transactional
    public T saveThing(T thing) {
        return repository.save(thing);
    }

    public T findThingById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<T> findAllThings() {
        return repository.findAll();
    }

    @Transactional
    public T updateThing(T thing) {
        return repository.save(thing);
    }

    @Transactional
    public void deleteThing(Long id) {
        repository.deleteById(id);
    }
}
