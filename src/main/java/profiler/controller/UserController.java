package profiler.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import profiler.repository.UserRepository;
import profiler.repository.MovieRepository;
import profiler.external.PreselectionServer;
import profiler.model.Movie;
import profiler.model.User;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {



    private UserRepository userRepository;

    @Autowired
    MovieRepository movieRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/all")
    public List<User> getAll(){
        List<User> users = this.userRepository.findAll();

        return users;
    }


    @PutMapping
    public void insert(@RequestBody User user){
        this.userRepository.insert(user);
    }


    @PostMapping
    public void update(@RequestBody User user){
        this.userRepository.save(user);
    }


    @GetMapping("/id/{id}")
    public User getById(@PathVariable("id") String id){
        User user = this.userRepository.findById(id);

        return user;
    }


    @PutMapping("/movie")
    public void addMovieToUserList(@RequestBody String userId, @RequestBody String movieId){
        Movie movie = this.movieRepository.findById(movieId);
        if (movie != null){
            User user = this.userRepository.findById(userId);
            List<Movie> userMovies = user.getMovies();
            userMovies.add(movie);
            user.setMovies(userMovies);
            this.userRepository.save(user);
        }
    }

    @RequestMapping(value = "{id}/movies", method = RequestMethod.GET)
    public List<Movie> listUserRatedMovies(@PathVariable("id") String id){
        return userRepository.findById(id).getMovies();
    }


    @RequestMapping(value = "/user/{userId}/movie/{movieid}", method = RequestMethod.PUT )
    public void updateUserList(@PathVariable("userId") String userId, @PathVariable("movieid") String movieid) {

        Movie movie = this.movieRepository.findById(movieid);
        User user = this.userRepository.findById(userId);
        List<Movie> userMovies = new ArrayList<>();
        userMovies = user.getMovies();

        if (!checkIfMovieIsOnList(userId,movieid)){
                userMovies.add(movie);
                user.setMovies(userMovies);
                this.userRepository.save(user);
            }
        }




    @RequestMapping(value = "/user/{id}/recommendation", method = RequestMethod.GET)
    public String getRecommendation(@PathVariable("id") String id){

        PreselectionServer ps = new PreselectionServer();
        String recommendedMovieId = ps.sendRecommendation(id);
        while (true){
            if( checkIfMovieIsOnList(id, recommendedMovieId))
                recommendedMovieId = ps.sendRecommendation(id);
            else
                break;
        }
        return recommendedMovieId;
    }


    boolean checkIfMovieIsOnList(String userId, String movieId){

        User user = this.userRepository.findById(userId);
        Movie movie = this.movieRepository.findById(movieId);
        List<Movie> userMovies = new ArrayList<>();
        userMovies = user.getMovies();
        boolean belongs = false;
        if (movie != null) {
            for (Movie m : userMovies) {
                if (m.getId().equals(movieId)) {
                    belongs = true;
                }
            }
        }
        return belongs;
    }

}
