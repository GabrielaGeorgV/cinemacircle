package bg.cinemacircle.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UpdateProfileRequest {
    @NotBlank
    @Size(min = 3, max = 50)
    @Pattern(regexp = "[a-zA-Z0-9_.-]+")
    private String username;
    @NotBlank
    @Email
    @Size(max = 254)
    private String email;
    public UpdateProfileRequest() {
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
