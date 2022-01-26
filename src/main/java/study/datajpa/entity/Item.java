package study.datajpa.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item implements Persistable<String> {
    /**
     * 만약 @GeneratedValue를 안쓴다면?
     * - PK가 있기 때문에 새로운 객체라고 판단하지 않는다.
     *      -> em.persist(entity)가 호출되지 않는다!
     *          -> em.merge(entity)가 실행된다.
     *              -> 머지란 DB에 있다는 가정으로 작동하므로 select문을 호출한다.
     *                  -> 그 후 Insert가 나간다.
     */
    @Id //@GeneratedValue
    private String id;

    @CreatedDate
    private LocalDateTime createdDate;

    public Item(String id){
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return createdDate == null;
    }
}
