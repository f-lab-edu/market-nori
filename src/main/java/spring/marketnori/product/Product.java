package spring.marketnori.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import spring.marketnori.common.audit.Auditable;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Product extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    private Long price;
    private Long stockQuantity;
    private LocalDateTime saleStartDate;
    private LocalDateTime saleEndDate;
    private Long categoryId;
}
