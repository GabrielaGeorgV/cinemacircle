package bg.cinemacircle.mapper;

import bg.cinemacircle.dto.response.UserResponse;
import bg.cinemacircle.model.AppUser;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
        public UserResponse toResponse(AppUser entity) {
            UserResponse dto = new UserResponse();
            dto.setId(entity.getId());
            dto.setUsername(entity.getUsername());
            dto.setEmail(entity.getEmail());
            dto.setRole(entity.getRole());
            dto.setEnabled(entity.isEnabled());
            return dto;
        }
}
