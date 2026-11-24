package bg.cinemacircle.dto.request;

import jakarta.validation.constraints.*;

import java.util.Set;

public class MovieRequest {
    @NotBlank
    @Size(max = 200)
    private String title;
    @Size(max = 5000)
    private String description;
    @NotNull
    @Min(1888)
    @Max(2100)
    private Integer releaseYear;
    @NotNull
    @Min(1)
    @Max(1500)
    private Integer durationMinutes;
    @Size(max = 1000)
    private String posterUrl;
    @NotEmpty
    private Set<@NotNull @Positive Long> genreIds;
    public MovieRequest() {
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
    public Set<Long> getGenreIds() {
        return genreIds;
    }
    public void setGenreIds(Set<Long> genreIds) {
        this.genreIds = genreIds;
    }
}
