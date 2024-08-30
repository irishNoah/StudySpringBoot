package com.example.StudySpringBoot.service;

import com.example.StudySpringBoot.entity.SOPUM;
import com.example.StudySpringBoot.repository.SOPUMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SOPUMService {

    @Autowired
    private SOPUMRepository sopumRepository;

    public SOPUM saveSOPUM(SOPUM sopum) {
        return sopumRepository.save(sopum);
    }
    
    public SOPUM save(SOPUM sopum) {
        return sopumRepository.save(sopum);
    }

    public SOPUM findSOPUMById(Long id) {
        return sopumRepository.findById(id).orElse(null);
    }

    public List<SOPUM> findAllSOPUMs() {
        return sopumRepository.findAll();
    }

    public SOPUM updateSOPUM(Long id, SOPUM sopumDetails) {
        Optional<SOPUM> sopumOptional = sopumRepository.findById(id);
        if (sopumOptional.isPresent()) {
            SOPUM sopum = sopumOptional.get();
            sopum.setName(sopumDetails.getName());
            sopum.setPrice(sopumDetails.getPrice());
            return sopumRepository.save(sopum);
        } else {
            return null;
        }
    }

    public void deleteSOPUM(Long id) {
        sopumRepository.deleteById(id);
    }
}
