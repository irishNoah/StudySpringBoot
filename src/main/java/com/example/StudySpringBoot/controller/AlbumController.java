package com.example.StudySpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudySpringBoot.entity.Album;
import com.example.StudySpringBoot.service.AlbumService;

@RestController
@RequestMapping("/albums")
public class AlbumController {

	@Autowired
    private AlbumService albumService;

    // Create
    @PostMapping
    public Album createAlbum(@RequestBody Album album) {
        return albumService.saveThing(album);
    }

    // Read all
    @GetMapping
    public List<Album> getAllAlbums() {
        return albumService.findAllAlbums();
    }

    // Read one by ID
    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable Long id) {
        Album album = albumService.findAlbumById(id);
        if (album != null) {
            return ResponseEntity.ok(album);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Album> updateAlbum(@PathVariable Long id, @RequestBody Album albumDetails) {
        Album updatedAlbum = albumService.updateAlbum(id, albumDetails);
        if (updatedAlbum != null) {
            return ResponseEntity.ok(updatedAlbum);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlbum(@PathVariable Long id) {
        albumService.deleteAlbum(id);
        return ResponseEntity.noContent().build();
    }
}
