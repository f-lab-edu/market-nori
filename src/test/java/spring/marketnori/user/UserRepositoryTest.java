package spring.marketnori.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;


@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository memberRepository;

    @Test
    public void testInsertAndSelect() {
        //given
        User member = new User();
        member.setId("nori");
        member.setName("노찬영");
        member.setPassword("1234");
        member.setPhone("01012345678");
        member.setEmail("abc@gmail.com");
        member.setAddress("서울특별시");

        //when
        User saveMember = memberRepository.save(member);
        Optional<User> findMember = memberRepository.findById(saveMember.getUserId());

        //then
        assertThat(findMember.get().getUserId()).isEqualTo(saveMember.getUserId());

    }
}
