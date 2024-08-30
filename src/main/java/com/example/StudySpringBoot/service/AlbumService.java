package com.example.StudySpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.example.StudySpringBoot.entity.Album;
import com.example.StudySpringBoot.repository.AlbumRepository;

@Service
@Primary
public class AlbumService extends ThingService<Album> {

	@Autowired
    private AlbumRepository albumRepository;

    // Create
    public Album saveThing(Album album) {
        return albumRepository.save(album);
    }

    // Read
    public List<Album> findAllAlbums() {
        return albumRepository.findAll();
    }

    public Album findAlbumById(Long id) {
        return albumRepository.findById(id).orElse(null);
    }

    // Update
    public Album updateAlbum(Long id, Album albumDetails) {
        Optional<Album> albumOptional = albumRepository.findById(id);
        if (albumOptional.isPresent()) {
            Album album = albumOptional.get();
            album.setArtist(albumDetails.getArtist());
            // Thing에서 상속받은 필드들 업데이트
            album.setName(albumDetails.getName());
            album.setPrice(albumDetails.getPrice());
            return albumRepository.save(album);
        } else {
            return null;
        }
    }

    // Delete
    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }
}
