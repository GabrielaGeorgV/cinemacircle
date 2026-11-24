package bg.cinemacircle.mapper;

import bg.cinemacircle.dto.response.GenreResponse;
import bg.cinemacircle.dto.response.UserResponse;
import bg.cinemacircle.model.Genre;

public class GenreMapper {
        public GenreResponse toResponse(Genre entity) {
            UserResponse dto = new UserResponse();
            dto.setId(entity.getId());
            dto.setUsername(entity.getUsername());
            dto.setEmail(entity.getEmail());
            dto.setRole(entity.getRole());
            dto.setEnabled(entity.isEnabled());
            return dto;
        }
}
