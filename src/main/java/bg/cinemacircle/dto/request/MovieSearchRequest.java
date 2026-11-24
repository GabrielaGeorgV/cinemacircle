package bg.cinemacircle.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class MovieSearchRequest {
    @Size(max = 200)
    private String title;
    @Min(1888)
    @Max(2100)
    private Integer year;
    @Positive
    private Long genreId;
    @Min(1)
    @Max(10)
    private Integer minScore;
    @Min(0)
    private int page = 0;
    @Min(1)
    @Max(50)
    private int size = 10;

    public MovieSearchRequest() {
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public Long getGenreId() {
        return genreId;
    }
    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }
    public Integer getMinScore() {
        return minScore;
    }
    public void setMinScore(Integer minScore) {
        this.minScore = minScore;
    }
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
}
