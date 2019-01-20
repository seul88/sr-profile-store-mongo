package profiler.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Movies")
public class Movie {

    @Id
    String id;
    String title;
    double rtAudienceNumRatings;
    double rtAudienceScore;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRtAudienceNumRatings() {
        return rtAudienceNumRatings;
    }

    public void setRtAudienceNumRatings(double rtAudienceNumRatings) {
        this.rtAudienceNumRatings = rtAudienceNumRatings;
    }

    public double getRtAudienceScore() {
        return rtAudienceScore;
    }

    public void setRtAudienceScore(double rtAudienceScore) {
        this.rtAudienceScore = rtAudienceScore;
    }

    public Movie() {
    }







}
