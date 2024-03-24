package spring.marketnori.cartitem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import spring.marketnori.cart.Cart;
import spring.marketnori.product.Product;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class CartItemRepositoryTest {

    @Autowired
    CartItemRepository cartItemRepository;

    @Test
    @Transactional
    public void testInsertAndSelect() {
        // given
        CartItem cartItem = new CartItem();
        cartItem.setCart(new Cart());
        cartItem.getCart().setCartId(1L);
        cartItem.setProduct(new Product());
        cartItem.getProduct().setProductId(1L);
        cartItem.setQuantity(12L);

        // when
        CartItem saveCartItem = cartItemRepository.save(cartItem);
        Optional<CartItem> findCartItem = cartItemRepository.findById(saveCartItem.getCartItemId());

        // then
        assertThat(findCartItem.get().getCartItemId()).isEqualTo(saveCartItem.getCartItemId());
    }
}
