package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.datajpa.entity.Team;

//@Repository 애노테이션을 생략해도 된다.
// Component 스캔 및 JPA 예외를 스프링 공통적으로 처리할수 있게하는 애노테이션
public interface TeamRepository extends JpaRepository<Team, Long> {
}
