package bg.cinemacircle.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class RatingRequest {
    @NotNull
    @Min(1)
    @Max(10)
    private Integer score;
    public RatingRequest() {
    }
    public Integer getScore() {
        return score;
    }
    public void setScore(Integer score) {
        this.score = score;
    }

}
