package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.datajpa.entity.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    /**
     * 쿼리 메소드 기능
     */
    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);
    List<Member> findTop3HelloBy();

    //@Query(name = "Member.findByUsername") - 명시하지 않아도 관례에 맞다면 동작한다.
    List<Member> findByUsername(@Param("username") String username);

    /**
     * 실무에서 가장 많이 쓴다.
     */
    @Query("select m from Member m where m.username= :username and m.age = :age")
    List<Member> findUser(@Param("username") String username, @Param("age") int age);
}
