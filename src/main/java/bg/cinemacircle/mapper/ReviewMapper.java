package bg.cinemacircle.mapper;

import bg.cinemacircle.dto.response.ReviewResponse;
import bg.cinemacircle.model.Review;

public class ReviewMapper {
    public ReviewResponse toResponse(Review entity) {
        ReviewResponse dto = new ReviewResponse();
        dto.setId(entity.getId());
        dto.setMovieId(entity.getMovie().getId());
        dto.setMovieTitle(entity.getMovie().getTitle());
        dto.setAuthorId(entity.getUser().getId());
        dto.setAuthorUsername(entity.getUser().getUsername());
        dto.setContent(entity.getContent());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }
}
