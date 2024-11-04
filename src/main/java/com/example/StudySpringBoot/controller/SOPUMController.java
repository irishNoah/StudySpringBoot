package com.example.StudySpringBoot.controller;

import com.example.StudySpringBoot.entity.CLOTH;
import com.example.StudySpringBoot.entity.FOOD;
import com.example.StudySpringBoot.entity.SOPUM;
import com.example.StudySpringBoot.service.SOPUMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sopums")
public class SOPUMController {

    @Autowired
    private SOPUMService sopumService;

    @GetMapping
    public List<SOPUM> getAllSOPUMs() {
        return sopumService.findAllSOPUMs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SOPUM> getSOPUMById(@PathVariable Long id) {
        SOPUM sopum = sopumService.findSOPUMById(id);
        if (sopum != null) {
            return ResponseEntity.ok(sopum);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public SOPUM createSOPUM(@RequestBody SOPUM sopum) {
        return sopumService.saveSOPUM(sopum);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SOPUM> updateSOPUM(@PathVariable Long id, @RequestBody SOPUM sopumDetails) {
        SOPUM sopum = sopumService.findSOPUMById(id);
        if (sopum == null) {
            return ResponseEntity.notFound().build();
        }

        // 공통 필드 업데이트
        sopum.setName(sopumDetails.getName());
        sopum.setPrice(sopumDetails.getPrice());

        // 자식 클래스에 대한 구체적인 타입 확인
        if (sopum instanceof CLOTH) {
            ((CLOTH) sopum).setMaker(((CLOTH) sopumDetails).getMaker());
        } else if (sopum instanceof FOOD) {
            ((FOOD) sopum).setMenu(((FOOD) sopumDetails).getMenu());
        }

        SOPUM updatedSopum = sopumService.save(sopum);
        return ResponseEntity.ok(updatedSopum);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSOPUM(@PathVariable Long id) {
        sopumService.deleteSOPUM(id);
        return ResponseEntity.noContent().build();
    }
}
