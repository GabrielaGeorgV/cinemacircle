package bg.cinemacircle.service;

import bg.cinemacircle.dto.response.FavoriteMovieResponse;

import java.util.List;

public interface FavoriteService {
    List<FavoriteMovieResponse> getMyFavorites(Long currentUserId,
                                               int page, int size);
    FavoriteMovieResponse add(Long currentUserId, Long movieId);
    void remove(Long currentUserId, Long movieId);
}
