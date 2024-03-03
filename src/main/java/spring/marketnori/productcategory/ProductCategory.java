package spring.marketnori.productcategory;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import spring.marketnori.common.audit.Auditable;
import spring.marketnori.product.Product;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class ProductCategory extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productCategoryId;
    private String categoryName;

    @OneToMany(mappedBy = "productCategory")
    List<Product> products = new ArrayList<>();

}
