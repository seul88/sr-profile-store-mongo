package profiler.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document(collection = "Users")
public class User {

    @Id
    private String id;
    private List<MovieRatedByUser> movies;

    public User() {
        this.movies = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<MovieRatedByUser> getMovies() {
        return movies;
    }

    public void addMovie(MovieRatedByUser movie){ this.movies.add(movie);}

    public void setMovies(List<MovieRatedByUser> movies) {
        this.movies = movies;
    }
}
