package spring.marketnori.cart;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import spring.marketnori.common.audit.Auditable;

@Entity
@Getter
@Setter
public class Cart extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    private Long memberId;

}
