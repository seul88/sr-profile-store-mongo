package profiler.controller;


import profiler.model.Movie;
import org.springframework.web.bind.annotation.*;
import profiler.repository.MovieRepository;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }


    @GetMapping("/all")
    public List<Movie> getAllMovies(){
        List<Movie> movies =  this.movieRepository.findAll();

        return movies;
    }

    @PutMapping
    public void insert(@RequestBody Movie place){
        this.movieRepository.insert(place);
    }

    @PostMapping
    public void update(@RequestBody Movie place){
        this.movieRepository.save(place);
    }

    @GetMapping("/id/{id}")
    public Movie getById(@PathVariable("id") String id){
        Movie place = this.movieRepository.findById(id);

        return place;
    }

    @PutMapping("/id/{id}")
    public void setMovieTitleById(@PathVariable("id") String id, @RequestBody String name){
        Movie place = this.movieRepository.findById(id);
        place.setTitle(name);
        this.movieRepository.save(place);
    }

    @GetMapping("/name/{name}")
    public Movie getByName(@PathVariable("name") String title){
        Movie place = this.movieRepository.findByTitleIgnoreCase(title);

        return place;
    }

    @PutMapping("/name/{name}")
    public void setMovieName(@PathVariable("name") String name, @RequestBody String ref){
        Movie place = this.movieRepository.findByTitleIgnoreCase(name);
        place.setTitle(ref);
        this.movieRepository.save(place);
    }




}
