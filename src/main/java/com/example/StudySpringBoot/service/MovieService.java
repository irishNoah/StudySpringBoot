package com.example.StudySpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.StudySpringBoot.entity.Movie;
import com.example.StudySpringBoot.repository.MovieRepository;

@Service
public class MovieService extends ThingService<Movie> {

	@Autowired
    private MovieRepository movieRepository;

    // Create
    public Movie saveThing(Movie movie) {
        return movieRepository.save(movie);
    }

    // Read
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    public Movie findMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    // Update
    public Movie updateMovie(Long id, Movie movieDetails) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isPresent()) {
            Movie movie = movieOptional.get();
            movie.setDirector(movieDetails.getDirector());
            movie.setActor(movieDetails.getActor());
            // Thing에서 상속받은 필드들 업데이트
            movie.setName(movieDetails.getName());
            movie.setPrice(movieDetails.getPrice());
            return movieRepository.save(movie);
        } else {
            return null;
        }
    }

    // Delete
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
