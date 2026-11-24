package bg.cinemacircle.dto.request;

import jakarta.validation.constraints.NotNull;

public class UserStatusRequest {
    @NotNull
    private Boolean enabled;
    public UserStatusRequest() {
    }
    public Boolean getEnabled() {
        return enabled;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

}
