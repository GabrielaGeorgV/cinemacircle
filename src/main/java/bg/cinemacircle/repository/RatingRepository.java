package bg.cinemacircle.repository;

import bg.cinemacircle.model.Movie;
import bg.cinemacircle.model.Rating;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    Optional<Rating> findByUser_IdAndMovie_Id(
            Long userId, Long movieId);
    long countByMovie_Id(Long movieId);
    @Query("select avg(r.score) from Rating r where r.movie.id = :movieId")
    Double findAverageScore(@Param("movieId") Long movieId);
    @Query("""
 select m from Movie m
 join Rating r on r.movie = m
 where m.active = true
 group by m
 having count(r) >= :minVotes
 order by avg(r.score) desc,
 count(r) desc, m.id asc
 """)
    List<Movie> findTopRated(
            @Param("minVotes") long minVotes,
            Pageable pageable);

}
