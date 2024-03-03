package spring.marketnori.productcategory.dto;

import lombok.Getter;
import lombok.Setter;
import spring.marketnori.productcategory.ProductCategory;

import java.util.List;

@Setter
@Getter
public class ProductListResponse {
    private List<ProductCategory> categories;
}
