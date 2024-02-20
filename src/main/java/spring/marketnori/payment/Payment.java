package spring.marketnori.payment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import spring.marketnori.common.audit.Auditable;
import spring.marketnori.orderinfo.OrderInfo;

@Entity
@Setter
@Getter
public class Payment extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_info_id")
    private OrderInfo orderInfo;

    private String paymentMethod;
    private Long amount;
    private String status;
}
