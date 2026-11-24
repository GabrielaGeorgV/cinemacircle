package bg.cinemacircle.dto.request;

import jakarta.validation.constraints.PastOrPresent;

import java.time.Instant;

public class WatchedRequest {
    @PastOrPresent
    private Instant watchedAt;
    public WatchedRequest() {
    }
    public Instant getWatchedAt() {
        return watchedAt;
    }
    public void setWatchedAt(Instant watchedAt) {
        this.watchedAt = watchedAt;
    }

}
