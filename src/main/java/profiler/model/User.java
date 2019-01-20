package profiler.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document(collection = "Users")
public class User {

    @Id
    private String id;
    private List<Movie> movies;


    public User() {
        this.movies = new ArrayList<>();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void addMovie(Movie movie){ this.movies.add(movie);}

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
