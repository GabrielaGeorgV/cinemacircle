package bg.cinemacircle.repository;

import bg.cinemacircle.model.WatchlistItem;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WatchlistItemRepository extends JpaRepository<WatchlistItem, Long> {
    Optional<WatchlistItem> findByUser_IdAndMovie_Id(
            Long userId, Long movieId);
    boolean existsByUser_IdAndMovie_Id(Long userId, Long movieId);
    List<WatchlistItem> findByUser_IdOrderByAddedAtDescIdDesc(
            Long userId, Pageable pageable);
}