package study.datajpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.datajpa.dto.MemberDto;
import study.datajpa.entity.Member;
import study.datajpa.repository.MemberRepository;
import study.datajpa.repository.MemberRepositoryCustom;

import javax.annotation.PostConstruct;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;

    @GetMapping("/members/v1/{id}")
    public String findMember(@PathVariable("id") Long id){
        Member member = memberRepository.findById(id).get();
        return member.getUsername();
    }

    /**
     * 이런 기능을 권장하지 않는다.
     * 조회용 이외로 사용한다면 예외상황을 너무 많이 고려해야한다.
     */
    @GetMapping("/members/v2/{id}")
    public String findMember(@PathVariable("id") Member member){
        return member.getUsername();
    }

    @PostConstruct
    public void init(){
        //memberRepository.save(new Member("userA"));
        for(int i=0;i<100;i++){
            memberRepository.save(new Member("user"+i, i));
        }
    }

    /**
     * 페이징과 정렬
     */
    @GetMapping("/v1/members")
    public Page<Member> list(@PageableDefault(size=5)  Pageable pageable){
        Page<Member> page = memberRepository.findAll(pageable);
        return page;
    }

    /**
     * 꼭 Dto로 반환하자
     * Entity로 반환하면 가까운 미레에 후회를 하게 될 것이다!
     */
    @GetMapping("/v2/members")
    public Page<MemberDto> list2(@PageableDefault(size=5)  Pageable pageable){
        return memberRepository.findAll(pageable)
                .map(MemberDto::new);
    }
}
