package profiler.repository;

import profiler.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String>, QueryDslPredicateExecutor<Movie> {

   Movie findByTitleIgnoreCase(String title);

   Movie findById(String id);


}
