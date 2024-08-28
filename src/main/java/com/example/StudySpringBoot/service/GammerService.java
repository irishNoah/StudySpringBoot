package com.example.StudySpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudySpringBoot.entity.Gammer;
import com.example.StudySpringBoot.repository.GammerRepository;

import jakarta.transaction.Transactional;

@Service
public class GammerService {
	@Autowired
    private GammerRepository gammerRepository;

    @Transactional
    public Gammer saveGammer(Gammer gammer) {
        return gammerRepository.save(gammer);
    }

    public List<Gammer> getAllGammers() {
        return gammerRepository.findAll();
    }

    public Optional<Gammer> getGammerById(Long id) {
        return gammerRepository.findById(id);
    }

    @Transactional
    public Gammer updateGammer(Long id, Gammer gammerDetails) {
        Optional<Gammer> optionalGammer = gammerRepository.findById(id);
        if (optionalGammer.isPresent()) {
            Gammer gammer = optionalGammer.get();
            gammer.setUsername(gammerDetails.getUsername());
            gammer.setTeamname(gammerDetails.getTeamname());
            gammer.setUserphonenum(gammerDetails.getUserphonenum());
            gammer.setUserage(gammerDetails.getUserage());
            gammer.setGender(gammerDetails.getGender());
            gammer.setCreatedDate(gammerDetails.getCreatedDate());
            gammer.setDescription(gammerDetails.getDescription());
            return gammerRepository.save(gammer);
        } else {
            return null; // or throw an exception
        }
    }

    @Transactional
    public void deleteGammer(Long id) {
        gammerRepository.deleteById(id);
    }
}
