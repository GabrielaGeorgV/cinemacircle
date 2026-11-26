package bg.cinemacircle.service;

import bg.cinemacircle.dto.request.UpdateProfileRequest;
import bg.cinemacircle.dto.request.UserStatusRequest;
import bg.cinemacircle.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse getProfile(Long currentUserId);
    UserResponse updateProfile(Long currentUserId,
                               UpdateProfileRequest request);
    List<UserResponse> getUsers(Long currentUserId, int page, int size);
    UserResponse setEnabled(Long currentUserId, Long targetUserId,
                            UserStatusRequest request);
}
