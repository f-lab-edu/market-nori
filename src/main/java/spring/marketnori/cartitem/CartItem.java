package spring.marketnori.cartitem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import spring.marketnori.common.audit.Auditable;

@Entity
@Getter
@Setter
public class CartItem extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;
    private Long cartId;
    private Long productId;
    private Long quantity;
}
