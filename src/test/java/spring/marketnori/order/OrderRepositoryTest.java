package spring.marketnori.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.marketnori.product.Product;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void testInsertAndSelect() {
        // given
        Order order = new Order();
        order.setMemberId(3L);
        order.setStatus("배송 중");
        order.setShippingAddress("서울특별시");

        // when
        Order saveOrder = orderRepository.save(order);
        Optional<Order> findOrder = orderRepository.findById(saveOrder.getOrderId());

        // then
        assertThat(findOrder.get().getOrderId()).isEqualTo(saveOrder.getOrderId());
    }
}
