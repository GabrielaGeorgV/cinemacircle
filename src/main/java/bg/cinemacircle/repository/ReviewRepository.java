package bg.cinemacircle.repository;

import bg.cinemacircle.model.Review;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Optional<Review> findByUser_IdAndMovie_Id(
            Long userId, Long movieId);
    List<Review> findByMovie_IdOrderByCreatedAtDescIdDesc(
            Long movieId, Pageable pageable);
    List<Review> findByUser_IdOrderByCreatedAtDescIdDesc(
            Long userId, Pageable pageable);

}
