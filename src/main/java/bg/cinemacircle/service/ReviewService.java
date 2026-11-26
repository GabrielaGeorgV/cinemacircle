package bg.cinemacircle.service;

import bg.cinemacircle.dto.request.ReviewRequest;
import bg.cinemacircle.dto.response.ReviewResponse;

import java.util.List;

public interface ReviewService {
    List<ReviewResponse> getMovieReviews(Long movieId,
                                         int page, int size);
    List<ReviewResponse> getMyReviews(Long currentUserId,
                                      int page, int size);
    ReviewResponse create(Long currentUserId, Long movieId,
                          ReviewRequest request);
    ReviewResponse update(Long currentUserId, Long reviewId,
                          ReviewRequest request);
    void delete(Long currentUserId, Long reviewId);
}
