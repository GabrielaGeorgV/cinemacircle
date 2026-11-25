package bg.cinemacircle.repository;

import bg.cinemacircle.model.FavoriteMovie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriteMovieRepository  extends JpaRepository<FavoriteMovie, Long> {
    Optional<FavoriteMovie> findByUser_IdAndMovie_Id(
            Long userId, Long movieId);
    boolean existsByUser_IdAndMovie_Id(Long userId, Long movieId);
    List<FavoriteMovie> findByUser_IdOrderByAddedAtDescIdDesc(
            Long userId, Pageable pageable);
}
