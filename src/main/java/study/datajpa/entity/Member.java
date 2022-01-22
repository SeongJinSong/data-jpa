package study.datajpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Member {
    @Id @GeneratedValue
    private Long id;
    private String name;

    //JPA 표준 스펙 : 표준생성자 있어야 한다.
    //proxy 기술 쓸때 proxy 객체 만들기 위함
    protected Member() {
    }

    public Member(String name) {
        this.name = name;
    }
}
