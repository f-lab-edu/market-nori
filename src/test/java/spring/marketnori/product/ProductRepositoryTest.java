package spring.marketnori.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import spring.marketnori.productcategory.ProductCategory;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class ProductRepositoryTest {
    @Autowired
    ProductRepository productRepository;

    @Test
    @Transactional
    public void testInsertAndSelect() {
        // given
        Product product = new Product();
        product.setName("한라봉");
        product.setPrice(12000L);
        product.setStockQuantity(50000L);
        product.setProductCategory(new ProductCategory());
        product.getProductCategory().setProductCategoryId(1L);

        // when
        Product saveProduct = productRepository.save(product);
        Optional<Product> findProduct = productRepository.findById(saveProduct.getProductId());

        // then
        assertThat(findProduct.get().getProductId()).isEqualTo(saveProduct.getProductId());
    }
}
