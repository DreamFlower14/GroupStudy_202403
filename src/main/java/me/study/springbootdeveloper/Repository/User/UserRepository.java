package me.study.springbootdeveloper.Repository.User;

import me.study.springbootdeveloper.domain.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // email 로 사용자 정보를 가져옴 -> email 이 유니크한 값이여야하는 이유
    // Ex) FROM users
    //     WHERE email = #{email}
    Optional<User> findByEmail(String email);
}