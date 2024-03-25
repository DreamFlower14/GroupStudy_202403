package me.study.springbootdeveloper.Service.User;

import lombok.RequiredArgsConstructor;
import me.study.springbootdeveloper.Repository.User.UserRepository;
import me.study.springbootdeveloper.domain.User.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
// UserDetailsService : 시큐리티에서 제공하는 인터페이스
// 스프링 시큐리티에서 사용자 정보를 가져오는 인터페이스
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    // 사용자 이름(email)으로 사용자의 정보를 가져오는 메서드
    @Override
    public User loadUserByUsername(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException((email)));
    }
}