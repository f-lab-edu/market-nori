package spring.marketnori.productcategory;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.marketnori.productcategory.dto.ProductListResponse;

import java.util.List;

@SpringBootTest
public class ProductCategoryServiceTest {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Test
    public void findProductCategoryList() {
        // given
        List<ProductListResponse.ProductCategoryDto> ProductCategoryList;

        // when
        ProductCategoryList = productCategoryService.findProductsByCategory();
        for (ProductListResponse.ProductCategoryDto productCategory : ProductCategoryList) {
            System.out.println("productCategory.id = " + productCategory.getCategoryId());
            System.out.println("productCategory.name = " + productCategory.getCategoryName());

            for(ProductListResponse.ProductDto product : productCategory.getProducts()) {
                System.out.println("product.id = " + product.getProductId());
                System.out.println("product.name = " + product.getProductName());
                System.out.println("product.price = " + product.getPrice());
                System.out.println("product.stockQuantity = " + product.getStockQuantity());
            }
            System.out.println("=========================================================================");
        }

        // then
        Assertions.assertThat(ProductCategoryList)
                .isNotNull()
                .isNotEmpty()
                .hasSize(4);
    }
}

