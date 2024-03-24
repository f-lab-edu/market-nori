package spring.marketnori.payment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import spring.marketnori.orderinfo.OrderInfo;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PaymentRepositoryTest {

    @Autowired
    PaymentRepository paymentRepository;

    @Test
    @Transactional
    public void testInsertAndSelect() {
        // given
        Payment payment = new Payment();
        payment.setOrderInfo(new OrderInfo());
        payment.getOrderInfo().setOrderInfoId(1L);
        payment.setPaymentMethod("신용카드");
        payment.setAmount(144000L);
        payment.setStatus("결제 완료");

        // when
        Payment savePayment = paymentRepository.save(payment);
        Optional<Payment> findPayment = paymentRepository.findById(savePayment.getPaymentId());

        // then
        assertThat(findPayment.get().getPaymentId()).isEqualTo(savePayment.getPaymentId());
    }
}
