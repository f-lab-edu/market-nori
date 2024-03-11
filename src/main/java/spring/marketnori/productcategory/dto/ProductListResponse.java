package spring.marketnori.productcategory.dto;

import lombok.Getter;
import lombok.Setter;
import spring.marketnori.product.Product;
import spring.marketnori.productcategory.ProductCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class ProductListResponse {
    private List<ProductCategoryDto> categories = new ArrayList<>();

    @Getter
    @Setter
    public static class ProductCategoryDto {
        private Long categoryId;
        private String categoryName;
        private List<ProductDto> products;

        public ProductCategoryDto(ProductCategory productCategory) {
            this.categoryId = productCategory.getProductCategoryId();
            this.categoryName = productCategory.getCategoryName();
            this.products = productCategory.getProducts().stream()
                    .map(product -> new ProductDto(product))
                    .collect(Collectors.toList());
        }
    }

    @Getter
    @Setter
    public static class ProductDto {
        private Long productId;
        private String productName;
        private Long stockQuantity;
        private Long price;

        public ProductDto(Product product) {
            this.productId = product.getProductId();
            this.productName = product.getName();
            this.stockQuantity = product.getStockQuantity();
            this.price = product.getPrice();
        }
    }
}
