package me.study.springbootdeveloper.domain.User;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User implements UserDetails {  // UserDetails : Spring Security 에서 제공하는 UserDetails 를 커스텀 하기위해 상속
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "nickname", unique = true)
    private String nickname;

    @Column(name = "password")
    private String password;

    @Builder
    public User(String email, String password, String auth, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    // 권한 반환
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // 사용자가 가지고 있는 권한 목록 반환
        return List.of(new SimpleGrantedAuthority("user"));
    }

    // 사용자의 id 를 반환 (반드시 고유한 값)
    @Override
    public String getUsername() {
        return email;
    }

    // 사용자의 패스워드 반환
    @Override
    public String getPassword() {
        return password;
    }
    // 계정 만료 여부 반환
    @Override
    public boolean isAccountNonExpired() { // 만료되었는지 확인하는 로직
        return true;    // true -> 만료되지 않음
    }
    
    // 계정 잠금 여부 반환
    @Override
    public boolean isAccountNonLocked() { // 계정 잠금되었는지 확인하는 로직
        return true;    // true -> 잠금되지 않음
    }

    // 패스워드 만료 여부 반환
    @Override
    public boolean isCredentialsNonExpired() { // 패스워드가 만료되었는지 확인
        return true;    // ture -> 만료되지 않았음
    }

    // 계정이 사용가능한지 반환
    @Override
    public boolean isEnabled() {
        return true;    // true -> 사용 가능
    }

    public User update(String nickname) {
        this.nickname = nickname;
        return this;
    }
}