package bg.cinemacircle.mapper;

import bg.cinemacircle.dto.response.WatchedMovieResponse;
import bg.cinemacircle.model.WatchedMovie;
import org.springframework.stereotype.Component;

@Component
public class WatchedMovieMapper {
    public WatchedMovieResponse toResponse(WatchedMovie entity) {
        WatchedMovieResponse dto = new WatchedMovieResponse();
        dto.setId(entity.getId());
        dto.setMovieId(entity.getMovie().getId());
        dto.setMovieTitle(entity.getMovie().getTitle());
        dto.setActive(entity.getMovie().isActive());
        dto.setWatchedAt(entity.getWatchedAt());
        return dto;
    }

}
