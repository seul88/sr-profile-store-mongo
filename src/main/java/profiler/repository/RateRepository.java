package profiler.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;
import profiler.model.MovieRatedByUser;

@Repository
public interface RateRepository extends MongoRepository<MovieRatedByUser, String>, QueryDslPredicateExecutor<MovieRatedByUser> {

    //MovieRatedByUser findById(String userId, String movieId);

}
