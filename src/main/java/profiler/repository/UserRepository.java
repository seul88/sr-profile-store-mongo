package profiler.repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;
import profiler.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>, QueryDslPredicateExecutor<User> {

    User findById(String id);

}
