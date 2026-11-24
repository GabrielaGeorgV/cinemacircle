package bg.cinemacircle.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ReviewRequest {
        @NotBlank
        @Size(min = 10, max = 5000)
        private String content;
        public ReviewRequest() {
        }
        public String getContent() {
            return content;
        }
        public void setContent(String content) {
            this.content = content;
        }
}
