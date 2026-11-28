package bg.cinemacircle.mapper;

import bg.cinemacircle.dto.response.FavoriteMovieResponse;
import bg.cinemacircle.model.FavoriteMovie;
import org.springframework.stereotype.Component;

@Component
public class FavoriteMovieMapper {
    public FavoriteMovieResponse toResponse(FavoriteMovie entity) {
        FavoriteMovieResponse dto = new FavoriteMovieResponse();
        dto.setId(entity.getId());
        dto.setMovieId(entity.getMovie().getId());
        dto.setMovieTitle(entity.getMovie().getTitle());
        dto.setActive(entity.getMovie().isActive());
        dto.setAddedAt(entity.getAddedAt());
        return dto;
    }
}
