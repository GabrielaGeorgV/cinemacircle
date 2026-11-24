package bg.cinemacircle.mapper;

import bg.cinemacircle.dto.response.GenreResponse;
import bg.cinemacircle.model.Genre;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper {
    public GenreResponse toResponse(Genre entity) {
        GenreResponse dto = new GenreResponse();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}