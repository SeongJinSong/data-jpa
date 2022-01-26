package study.datajpa.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

/**
 * 진짜 JPA 상속관계가 아닌 속성만 내리는 상속이라는 어노테이션
 * 이 속성을 안쓰면 자식 테이블에 속성이 추가되지 않는다.
 */
@MappedSuperclass
@Getter
public class JpaBaseEntity {
    @Column(updatable = false)
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @PrePersist
    public void prePersist(){
        LocalDateTime now = LocalDateTime.now();
        createdDate = now;
        updatedDate = now;
    }
    @PreUpdate
    public void preUpdate(){
        updatedDate = LocalDateTime.now();
    }
}
