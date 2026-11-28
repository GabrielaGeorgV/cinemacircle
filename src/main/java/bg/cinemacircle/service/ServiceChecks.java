package bg.cinemacircle.service;

import bg.cinemacircle.exception.ForbiddenOperationException;
import bg.cinemacircle.exception.ResourceNotFoundException;
import bg.cinemacircle.model.AppUser;
import bg.cinemacircle.model.Movie;
import bg.cinemacircle.model.enums.Role;
import bg.cinemacircle.repository.MovieRepository;
import bg.cinemacircle.repository.UserRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ServiceChecks {
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final Validator validator;

    public ServiceChecks(UserRepository userRepository,
                         MovieRepository movieRepository,
                         Validator validator) {
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
        this.validator = validator;
    }

    public void id(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Id must be positive");
        }
    }

    public PageRequest page(int page, int size) {
        if (page < 0 || size < 1 || size > 50) {
            throw new IllegalArgumentException("Invalid page or size");
        }
        return PageRequest.of(page, size);
    }

    public void validate(Object request) {
        if (request == null) {
            throw new IllegalArgumentException("Request is required");
        }
        Set<ConstraintViolation<Object>> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            ConstraintViolation<Object> error = errors.iterator().next();
            throw new IllegalArgumentException(
                    error.getPropertyPath() + ": " + error.getMessage());
        }
    }

    public String text(String value, int min, int max) {
        if (value == null) {
            throw new IllegalArgumentException("Text is required");
        }
        String result = value.trim();
        if (result.length() < min || result.length() > max) {
            throw new IllegalArgumentException("Invalid text length");
        }
        return result;
    }

    public String optionalText(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        return value.trim();
    }

    public AppUser user(Long currentUserId) {
        id(currentUserId);
        AppUser user = userRepository.findById(currentUserId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        if (!user.isEnabled()) {
            throw new ForbiddenOperationException("Account is disabled");
        }
        return user;
    }

    public AppUser admin(Long currentUserId) {
        AppUser user = user(currentUserId);
        if (user.getRole() != Role.ADMIN) {
            throw new ForbiddenOperationException("Admin role is required");
        }
        return user;
    }

    public Movie movie(Long movieId) {
        id(movieId);
        return movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found"));
    }

    public Movie activeMovie(Long movieId) {
        id(movieId);
        return movieRepository.findByIdAndActiveTrue(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found"));
    }

    public Movie lockActiveMovie(Long movieId) {
        id(movieId);
        return movieRepository.findByIdForUpdate(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found"));
    }

    public Movie lockMovie(Long movieId) {
        id(movieId);
        return movieRepository.findAnyByIdForUpdate(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found"));
    }
}
