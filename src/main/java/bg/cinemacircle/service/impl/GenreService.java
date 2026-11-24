package bg.cinemacircle.service.impl;

import bg.cinemacircle.dto.request.GenreRequest;
import bg.cinemacircle.dto.response.GenreResponse;

import java.util.List;

public interface GenreService {
    List<GenreResponse> getAll();
    GenreResponse create(Long currentUserId, GenreRequest request);
    GenreResponse update(Long currentUserId, Long genreId,
                         GenreRequest request);
    void delete(Long currentUserId, Long genreId);
}
