package spring.marketnori.orderinfo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import spring.marketnori.common.audit.Auditable;

@Entity
@Setter
@Getter
public class OrderInfo extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Long memberId;
    private String shippingAddress;
    private String status;
}
