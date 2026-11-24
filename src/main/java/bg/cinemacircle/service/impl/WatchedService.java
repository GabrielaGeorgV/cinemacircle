package bg.cinemacircle.service.impl;

import bg.cinemacircle.dto.request.WatchedRequest;
import bg.cinemacircle.dto.response.WatchedMovieResponse;

import java.util.List;

public interface WatchedService {
    List<WatchedMovieResponse> getMyHistory(Long currentUserId,
                                            int page, int size);
    WatchedMovieResponse markAsWatched(Long currentUserId,
                                       Long movieId, WatchedRequest request);
    void remove(Long currentUserId, Long movieId);
}
