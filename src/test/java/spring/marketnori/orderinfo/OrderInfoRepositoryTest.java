package spring.marketnori.orderinfo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OrderInfoRepositoryTest {

    @Autowired
    OrderInfoRepository orderRepository;

    @Test
    public void testInsertAndSelect() {
        // given
        OrderInfo order = new OrderInfo();
        order.setMemberId(3L);
        order.setStatus("배송 중");
        order.setShippingAddress("서울특별시");

        // when
        OrderInfo saveOrder = orderRepository.save(order);
        Optional<OrderInfo> findOrder = orderRepository.findById(saveOrder.getOrderId());

        // then
        assertThat(findOrder.get().getOrderId()).isEqualTo(saveOrder.getOrderId());
    }
}
