package bg.cinemacircle.service;

import bg.cinemacircle.dto.request.MovieRequest;
import bg.cinemacircle.dto.request.MovieSearchRequest;
import bg.cinemacircle.dto.response.MovieResponse;

import java.util.List;

public interface MovieService {
    List<MovieResponse> search(MovieSearchRequest request);
    MovieResponse getById(Long movieId);
    List<MovieResponse> getTopRated(int page, int size);
    MovieResponse create(Long currentUserId, MovieRequest request);
    MovieResponse update(Long currentUserId, Long movieId,
                         MovieRequest request);
    void deactivate(Long currentUserId, Long movieId);

}
