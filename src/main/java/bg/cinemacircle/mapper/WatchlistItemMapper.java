package bg.cinemacircle.mapper;

import bg.cinemacircle.dto.response.WatchlistItemResponse;
import bg.cinemacircle.model.WatchlistItem;

public class WatchlistItemMapper {
    public WatchlistItemResponse toResponse(WatchlistItem entity) {
        WatchlistItemResponse dto = new WatchlistItemResponse();
        dto.setId(entity.getId());
        dto.setMovieId(entity.getMovie().getId());
        dto.setMovieTitle(entity.getMovie().getTitle());
        dto.setActive(entity.getMovie().isActive());
        dto.setAddedAt(entity.getAddedAt());
        return dto;
    }
}
