package me.study.springbootdeveloper.Service.User;

import lombok.RequiredArgsConstructor;
import me.study.springbootdeveloper.Repository.User.UserRepository;
import me.study.springbootdeveloper.domain.User.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public User loadUserByUsername(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException((email)));
    }
}