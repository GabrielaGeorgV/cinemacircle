package bg.cinemacircle.repository;

import bg.cinemacircle.model.AppUser;
import bg.cinemacircle.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    Optional<Genre> findByNameIgnoreCase(String name);
    boolean existsByNameIgnoreCase(String name);
}
