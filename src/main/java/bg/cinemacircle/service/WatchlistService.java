package bg.cinemacircle.service;

import bg.cinemacircle.dto.response.WatchlistItemResponse;

import java.util.List;

public interface WatchlistService {
    List<WatchlistItemResponse> getMyWatchlist(Long currentUserId,
                                               int page, int size);
    WatchlistItemResponse add(Long currentUserId, Long movieId);
    void remove(Long currentUserId, Long movieId);
}
