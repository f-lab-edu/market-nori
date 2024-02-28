package spring.marketnori.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import spring.marketnori.common.audit.Auditable;
import spring.marketnori.productcategory.ProductCategory;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Product extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;

    private String name;
    private Long price;
    private Long stockQuantity;
    private LocalDateTime saleStartDate;
    private LocalDateTime saleEndDate;
}
