package bg.cinemacircle.repository;

import bg.cinemacircle.model.Movie;
import jakarta.persistence.LockModeType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findByIdAndActiveTrue(Long id);
    boolean existsByGenres_Id(Long genreId);
    @Query("""
 select m from Movie m
 left join m.genres g
 left join Rating r on r.movie = m
 where m.active = true
 and lower(m.title) like lower(:titlePattern)
 and (:year is null or m.releaseYear = :year)
 and (:genreId is null or g.id = :genreId)
 group by m
 having (:minScore is null or avg(r.score) >= :minScore)
 order by m.title asc, m.id asc
 """)
    List<Movie> search(
            @Param("titlePattern") String titlePattern,
            @Param("year") Integer year,
            @Param("genreId") Long genreId,
            @Param("minScore") Double minScore,
            Pageable pageable);
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select m from Movie m where m.id = :id and m.active = true")
    Optional<Movie> findByIdForUpdate(@Param("id") Long id);

}
