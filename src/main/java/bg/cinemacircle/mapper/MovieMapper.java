
package bg.cinemacircle.mapper;

import bg.cinemacircle.dto.response.GenreResponse;
import bg.cinemacircle.dto.response.MovieResponse;
import bg.cinemacircle.mapper.GenreMapper;
import bg.cinemacircle.model.Genre;
import bg.cinemacircle.model.Movie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieMapper {
    private final GenreMapper genreMapper;
    public MovieMapper(GenreMapper genreMapper) {
        this.genreMapper = genreMapper;
    }
    public MovieResponse toResponse(Movie entity,
                                    Double averageRating, long ratingCount) {
        MovieResponse dto = new MovieResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setReleaseYear(entity.getReleaseYear());
        dto.setDurationMinutes(entity.getDurationMinutes());
        dto.setPosterUrl(entity.getPosterUrl());
        dto.setActive(entity.isActive());
        dto.setAverageRating(averageRating);
        dto.setRatingCount(ratingCount);
        List<GenreResponse> genres = new ArrayList<>();
        for (Genre genre : entity.getGenres()) {
            genres.add(genreMapper.toResponse(genre));
        }
        dto.setGenres(genres);
        return dto;
    }
}
