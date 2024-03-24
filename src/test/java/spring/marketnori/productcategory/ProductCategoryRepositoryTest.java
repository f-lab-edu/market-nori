package spring.marketnori.productcategory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Test
    public void testInsertAndSelect() {
        // given
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("과일");

        // when
        ProductCategory saveProductCategory = productCategoryRepository.save(productCategory);
        Optional<ProductCategory> findProductCategory = productCategoryRepository.findById(saveProductCategory.getProductCategoryId());

        // then
        assertThat(findProductCategory.get().getProductCategoryId()).isEqualTo(saveProductCategory.getProductCategoryId());
    }
}
