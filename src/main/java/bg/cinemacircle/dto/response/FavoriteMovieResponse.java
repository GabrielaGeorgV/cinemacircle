package bg.cinemacircle.dto.response;

import java.time.Instant;

public class FavoriteMovieResponse {
    private Long id;
    private Long movieId;
    private String movieTitle;
    private boolean active;
    private Instant addedAt;
    public FavoriteMovieResponse() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getMovieId() {
        return movieId;
    }
    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
    public String getMovieTitle() {
        return movieTitle;
    }
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public Instant getAddedAt() {
        return addedAt;
    }
    public void setAddedAt(Instant addedAt) {
        this.addedAt = addedAt;
    }
}
