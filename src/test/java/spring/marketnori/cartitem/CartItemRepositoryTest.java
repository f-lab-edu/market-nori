package spring.marketnori.cartitem;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class CartItemRepositoryTest {

    @Autowired
    CartItemRepository cartItemRepository;

    @Test
    public void testInsertAndSelect() {
        // given
        CartItem cartItem = new CartItem();
        cartItem.setCartId(1L);
        cartItem.setProductId(1L);
        cartItem.setQuantity(12L);

        // when
        CartItem saveCartItem = cartItemRepository.save(cartItem);
        Optional<CartItem> findCartItem = cartItemRepository.findById(saveCartItem.getCartItemId());

        // then
        assertThat(findCartItem.get().getCartItemId()).isEqualTo(saveCartItem.getCartItemId());
    }
}
