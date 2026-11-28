package bg.cinemacircle.service.impl;

import bg.cinemacircle.dto.request.UpdateProfileRequest;
import bg.cinemacircle.dto.request.UserStatusRequest;
import bg.cinemacircle.dto.response.UserResponse;
import bg.cinemacircle.exception.ConflictException;
import bg.cinemacircle.exception.ResourceNotFoundException;
import bg.cinemacircle.mapper.UserMapper;
import bg.cinemacircle.model.AppUser;
import bg.cinemacircle.repository.UserRepository;
import bg.cinemacircle.service.ServiceChecks;
import bg.cinemacircle.service.UserService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ServiceChecks checks;

    public UserServiceImpl(UserRepository userRepository,
                           UserMapper userMapper,
                           ServiceChecks checks) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.checks = checks;
    }

    @Override
    public UserResponse getProfile(Long currentUserId) {
        return userMapper.toResponse(checks.user(currentUserId));
    }

    @Override
    @Transactional
    public UserResponse updateProfile(Long currentUserId,
                                      UpdateProfileRequest request) {
        AppUser user = checks.user(currentUserId);
        checks.validate(request);
        String username = checks.text(request.getUsername(), 3, 50)
                .toLowerCase(Locale.ROOT);
        String email = checks.text(request.getEmail(), 1, 254)
                .toLowerCase(Locale.ROOT);
        if (!user.getUsername().equalsIgnoreCase(username)
                && userRepository.existsByUsernameIgnoreCase(username)) {
            throw new ConflictException("Username is already used");
        }
        if (!user.getEmail().equalsIgnoreCase(email)
                && userRepository.existsByEmailIgnoreCase(email)) {
            throw new ConflictException("Email is already used");
        }
        user.setUsername(username);
        user.setEmail(email);
        try {
            userRepository.saveAndFlush(user);
        } catch (DataIntegrityViolationException ex) {
            throw new ConflictException("Username or email is already used");
        }
        return userMapper.toResponse(user);
    }

    @Override
    public List<UserResponse> getUsers(Long currentUserId,
                                       int page, int size) {
        checks.admin(currentUserId);
        List<AppUser> users = userRepository.findAll(
                checks.page(page, size).withSort(Sort.by("id"))).getContent();
        List<UserResponse> result = new ArrayList<>();
        for (AppUser user : users) {
            result.add(userMapper.toResponse(user));
        }
        return result;
    }

    @Override
    @Transactional
    public UserResponse setEnabled(Long currentUserId, Long targetUserId,
                                   UserStatusRequest request) {
        checks.admin(currentUserId);
        checks.id(targetUserId);
        checks.validate(request);
        AppUser target = userRepository.findById(targetUserId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        target.setEnabled(request.getEnabled());
        return userMapper.toResponse(userRepository.saveAndFlush(target));
    }
}
