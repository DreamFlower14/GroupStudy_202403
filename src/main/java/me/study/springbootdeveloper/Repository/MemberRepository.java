package me.study.springbootdeveloper.Repository;

import me.study.springbootdeveloper.DAO.Blog.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
