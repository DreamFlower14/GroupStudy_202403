package me.study.springbootdeveloper.Service.User;

import lombok.RequiredArgsConstructor;
import me.study.springbootdeveloper.DAO.User.AddUserRequest;
import me.study.springbootdeveloper.Repository.User.UserRepository;
import me.study.springbootdeveloper.domain.User.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public Long save(AddUserRequest dto) {
        return userRepository.save(User.builder()
                .email(dto.getEmail())
                // 패스워드 암호화
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .build()).getId();
    }
}