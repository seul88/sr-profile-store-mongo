package profiler.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "MoviesRated")
public class MovieRatedByUser {

    String id;
    //id filmu
    //ocena
    //timestamp + sprawdzanie gdy data nowsza, zmiana oceny

}
