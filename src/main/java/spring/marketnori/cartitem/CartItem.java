package spring.marketnori.cartitem;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import spring.marketnori.cart.Cart;
import spring.marketnori.common.audit.Auditable;
import spring.marketnori.product.Product;

@Entity
@Getter
@Setter
public class CartItem extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private Long quantity;
}
