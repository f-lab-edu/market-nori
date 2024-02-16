package spring.marketnori.orderdetail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.marketnori.product.Product;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Test
    public void testInsertAndSelect() {
        // given
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(1L);
        orderDetail.setProductId(1L);
        orderDetail.setOrderPrice(12000L);
        orderDetail.setQuantity(12L);

        // when
        OrderDetail saveOrderDetail = orderDetailRepository.save(orderDetail);
        Optional<OrderDetail> findOrderDetail = orderDetailRepository.findById(saveOrderDetail.getOrderItemId());

        // then
        assertThat(findOrderDetail.get().getOrderItemId()).isEqualTo(saveOrderDetail.getOrderItemId());
    }
}
