package spring.marketnori.product.dto;

import lombok.Getter;
import lombok.Setter;
import spring.marketnori.product.Product;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ProductsResponse {
    private List<ProductDto> productDtoList;

    @Getter
    @Setter
    public static class ProductDto {
        private Long productId;
        private String categoryName;
        private String name;
        private Long price;
        private Long stockQuantity;
        private LocalDateTime saleStartDate;
        private LocalDateTime saleEndDate;

        public ProductDto(Product product) {
            this.productId = product.getProductId();
            this.categoryName = product.getProductCategory().getCategoryName();
            this.name = product.getName();
            this.price = product.getPrice();
            this.stockQuantity = product.getStockQuantity();
            this.saleStartDate = product.getSaleStartDate();
            this.saleEndDate = product.getSaleEndDate();
        }
    }
}
