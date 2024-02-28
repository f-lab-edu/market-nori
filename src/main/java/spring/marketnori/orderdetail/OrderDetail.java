package spring.marketnori.orderdetail;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import spring.marketnori.common.audit.Auditable;
import spring.marketnori.orderinfo.OrderInfo;
import spring.marketnori.product.Product;

@Entity
@Setter
@Getter
public class OrderDetail extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_info_id")
    private OrderInfo orderInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private Long orderPrice;
    private Long quantity;
}
