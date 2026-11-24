package bg.cinemacircle.model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(
        name = "reviews",
        uniqueConstraints = @UniqueConstraint(
                name = "uq_reviews_user_movie",
                columnNames = {"user_id", "movie_id"}
        )
)
public class Review {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "user_id", nullable = false)
        private AppUser user;
        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "movie_id", nullable = false)
        private Movie movie;
        @Column(nullable = false, length = 5000)
        private String content;
        @Column(name = "created_at", nullable = false)
        private Instant createdAt;
        public Review() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
