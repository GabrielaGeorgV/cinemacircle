package bg.cinemacircle.mapper;

import bg.cinemacircle.dto.response.RatingResponse;
import bg.cinemacircle.model.Rating;

public class RatingMapper {
    public RatingResponse toResponse(Rating entity) {
        RatingResponse dto = new RatingResponse();
        dto.setId(entity.getId());
        dto.setUserId(entity.getUser().getId());
        dto.setMovieId(entity.getMovie().getId());
        dto.setScore(entity.getScore());
        return dto;
    }
}
