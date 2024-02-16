package spring.marketnori.member;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import spring.marketnori.common.audit.Auditable;

@Entity
@Setter
@Getter
public class Member extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    private String id;
    private String password;
    private String name;
    private String phone;
    private String email;
    private String address;

}
