package spring.marketnori.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
public class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
//    @Rollback(value = false)
    public void testInsertAndSelect() {
        //given
        Member member = new Member();
        member.setId("nori");
        member.setName("노찬영");
        member.setPassword("1234");
        member.setPhone("01012345678");
        member.setEmail("abc@gmail.com");
        member.setAddress("서울특별시");

        //when
        Member saveMember = memberRepository.save(member);
        Optional<Member> findMember = memberRepository.findById(saveMember.getMemberId());

        //then
        assertThat(findMember.get().getMemberId()).isEqualTo(saveMember.getMemberId());

    }
}
