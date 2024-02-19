package spring.marketnori.orderdetail;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import spring.marketnori.common.audit.Auditable;

@Entity
@Setter
@Getter
public class OrderDetail extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;
    private Long orderId;
    private Long productId;
    private Long orderPrice;
    private Long quantity;
}
