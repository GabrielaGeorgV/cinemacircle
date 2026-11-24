package bg.cinemacircle.dto.response;

import java.util.ArrayList;
import java.util.List;

public class MovieResponse {
    private Long id;
    private String title;
    private String description;
    private Integer releaseYear;
    private Integer durationMinutes;
    private String posterUrl;
    private boolean active;
    private List<GenreResponse> genres = new ArrayList<>();
    private Double averageRating;
    private long ratingCount;

    public MovieResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }
    public Integer getDurationMinutes() {
        return durationMinutes;
    }
    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }
    public String getPosterUrl() {
        return posterUrl;
    }
    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public List<GenreResponse> getGenres() {
        return genres;
    }
    public void setGenres(List<GenreResponse> genres) {
        this.genres = genres;
    }
    public Double getAverageRating() {
        return averageRating;
    }
    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }
    public long getRatingCount() {
        return ratingCount;
    }
    public void setRatingCount(long ratingCount) {
        this.ratingCount = ratingCount;
    }
}