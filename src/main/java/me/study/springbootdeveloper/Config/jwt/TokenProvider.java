package me.study.springbootdeveloper.Config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import me.study.springbootdeveloper.domain.User.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class TokenProvider {
    // JwtProperties.java 에서 클래스에 @component 를 사용해 빈으로 등록
    // 클래스 내에서 @RequiredArgsConstructor 를 사용해 final 로 생성
    private final JwtProperties jwtProperties;

    public String generateToken(User user, Duration expiredAt){
        Date now = new Date();
        return makeToken(new Date(now.getTime() + expiredAt.toMillis()), user);
    }
    // Jwts 가 무엇인지 알아두기

    /**
     * JWT 토큰 생성 메서드
     * */
    private String makeToken(Date expiry, User user) {
        Date now = new Date();

        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)   // 헤더 typ : JWT
                .setIssuer(jwtProperties.getIssuer())           // 내용 iss : sunghh1004@naver.com ( properties.yml 에서 설정한 값 )
                .setIssuedAt(now)                               // 내용 iat : 현재 시간
                .setExpiration(expiry)                          // 내용 exp : expiry 멤버 변수값
                .setSubject(user.getEmail())                    // 내용 sub : 유저의 이메일
                .claim("id", user.getId())                   // 클레임 id : 유저의 ID
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())   // 서명 : 비밀값과 함께 해시값을 HS256 방식으로 암호화
                .compact();
    }

    /**
     * JWT 토큰 유효성 검증 메서드
     * */
    public boolean validToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(jwtProperties.getSecretKey())    // 비밀값으로 복호화
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 토큰 기반으로 인증 정보를 가져오는 메서드
     * */
    public Authentication getAuthentication(String token) {
        Claims claims = getClaims(token);
        Set<SimpleGrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));

        return new UsernamePasswordAuthenticationToken(new org.springframework.security.core.userdetails.User(claims.getSubject(), "", authorities), token, authorities);
    }

    /**
     * 토큰 기반으로 유저 ID 를 가져오는 메서드
     * */
    public Long getUserId(String token) {
        Claims claims = getClaims(token);
        return claims.get("id", Long.class);
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(jwtProperties.getSecretKey())
                .parseClaimsJws(token)
                .getBody();
    }
}
