package com.example.StudySpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.StudySpringBoot.entity.Cook;
import com.example.StudySpringBoot.repository.CookRepository;

@Service
public class CookService extends ThingService<Cook> {

	@Autowired
    private CookRepository cookRepository;

    // Create
    public Cook saveThing(Cook cook) {
        return cookRepository.save(cook);
    }

    // Read
    public List<Cook> findAllCooks() {
        return cookRepository.findAll();
    }

    public Cook findCookById(Long id) {
        return cookRepository.findById(id).orElse(null);
    }

    // Update
    public Cook updateCook(Long id, Cook cookDetails) {
        Optional<Cook> cookOptional = cookRepository.findById(id);
        if (cookOptional.isPresent()) {
            Cook cook = cookOptional.get();
            cook.setCooker(cookDetails.getCooker());
            // Thing에서 상속받은 필드들 업데이트
            cook.setName(cookDetails.getName());
            cook.setPrice(cookDetails.getPrice());
            return cookRepository.save(cook);
        } else {
            return null;
        }
    }

    // Delete
    public void deleteCook(Long id) {
        cookRepository.deleteById(id);
    }
}
