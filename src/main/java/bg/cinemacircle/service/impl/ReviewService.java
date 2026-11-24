package bg.cinemacircle.service.impl;

import bg.cinemacircle.dto.request.RatingRequest;
import bg.cinemacircle.dto.response.RatingResponse;

import java.util.List;

public interface ReviewService {
    RatingResponse setRating(Long currentUserId, Long movieId,
                             RatingRequest request);
    RatingResponse getMyRating(Long currentUserId, Long movieId);
    void deleteMyRating(Long currentUserId, Long movieId);
    List<RatingResponse> getMovieRatings(Long movieId,
                                         int page, int size);

}
