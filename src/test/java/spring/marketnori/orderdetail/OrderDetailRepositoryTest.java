package spring.marketnori.orderdetail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import spring.marketnori.orderinfo.OrderInfo;
import spring.marketnori.product.Product;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Test
    @Transactional
    public void testInsertAndSelect() {
        // given
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderInfo(new OrderInfo());
        orderDetail.getOrderInfo().setOrderInfoId(1L);
        orderDetail.setProduct(new Product());
        orderDetail.getProduct().setProductId(1L);
        orderDetail.setOrderPrice(12000L);
        orderDetail.setQuantity(12L);

        // when
        OrderDetail saveOrderDetail = orderDetailRepository.save(orderDetail);
        Optional<OrderDetail> findOrderDetail = orderDetailRepository.findById(saveOrderDetail.getOrderItemId());

        // then
        assertThat(findOrderDetail.get().getOrderItemId()).isEqualTo(saveOrderDetail.getOrderItemId());
    }
}
