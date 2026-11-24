package bg.cinemacircle.dto.response;

public class RatingResponse {
        private Long id;
        private Long userId;
        private Long movieId;
        private Integer score;
        public RatingResponse() {
        }
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public Long getUserId() {
            return userId;
        }
        public void setUserId(Long userId) {
            this.userId = userId;
        }
        public Long getMovieId() {
            return movieId;
        }
        public void setMovieId(Long movieId) {
            this.movieId = movieId;
        }
        public Integer getScore() {
            return score;
        }
        public void setScore(Integer score) {
            this.score = score;
        }
}
