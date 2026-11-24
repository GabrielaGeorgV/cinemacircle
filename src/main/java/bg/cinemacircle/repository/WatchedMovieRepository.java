package bg.cinemacircle.repository;

import bg.cinemacircle.model.WatchedMovie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WatchedMovieRepository extends JpaRepository<WatchedMovie, Long> {
    Optional<WatchedMovie> findByUser_IdAndMovie_Id(
            Long userId, Long movieId);
    boolean existsByUser_IdAndMovie_Id(Long userId, Long movieId);
    List<WatchedMovie> findByUser_IdOrderByWatchedAtDescIdDesc(
            Long userId, Pageable pageable);
}
