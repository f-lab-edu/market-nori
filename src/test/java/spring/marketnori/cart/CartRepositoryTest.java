package spring.marketnori.cart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class CartRepositoryTest {

    @Autowired
    CartRepository cartRepository;

    @Test
    public void testInsertAndSelect() {
        // given
        Cart cart = new Cart();
        cart.setMemberId(3L);

        // when
        Cart saveCart = cartRepository.save(cart);
        Optional<Cart> findCart = cartRepository.findById(saveCart.getCartId());

        // then
        assertThat(findCart.get().getCartId()).isEqualTo(saveCart.getCartId());
    }
}
