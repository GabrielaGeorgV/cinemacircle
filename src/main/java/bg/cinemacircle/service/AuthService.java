package bg.cinemacircle.service;

import bg.cinemacircle.dto.request.LoginRequest;
import bg.cinemacircle.dto.request.RegisterRequest;
import bg.cinemacircle.dto.response.AuthResponse;
import bg.cinemacircle.dto.response.UserResponse;

public interface AuthService {
    UserResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}
