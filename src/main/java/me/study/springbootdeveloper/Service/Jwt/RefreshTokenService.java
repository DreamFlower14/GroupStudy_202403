package me.study.springbootdeveloper.Service.Jwt;

import lombok.RequiredArgsConstructor;
import me.study.springbootdeveloper.Repository.Jwt.RefreshTokenRepository;
import me.study.springbootdeveloper.domain.Jwt.RefreshToken;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;
    public RefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected token"));
    }
}