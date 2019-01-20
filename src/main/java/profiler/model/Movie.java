package profiler.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Movies")
public class Movie {

    @Id
    String id;
    String title;
    String rtAudienceNumRatings;
    String rtAudienceScore;

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

    public String getRtAudienceNumRatings() {
        return rtAudienceNumRatings;
    }

    public void setRtAudienceNumRatings(String rtAudienceNumRatings) {
        this.rtAudienceNumRatings = rtAudienceNumRatings;
    }

    public String getRtAudienceScore() {
        return rtAudienceScore;
    }

    public void setRtAudienceScore(String rtAudienceScore) {
        this.rtAudienceScore = rtAudienceScore;
    }

    public Movie() {
    }







}
