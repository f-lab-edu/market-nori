package spring.marketnori.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.transaction.annotation.Transactional;
import spring.marketnori.product.dto.ProductsResponse;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;

    @Test
    @Transactional
    public void productToProductDtoConvertTest() {
        // given
        List<Product> products = productRepository.findProductBy("Lettuce");
        Product product = productRepository.findById(14L).get();
        ProductsResponse.ProductDto productDto = new ProductsResponse.ProductDto(product);

        // when
        List<ProductsResponse.ProductDto> productDtoList = ReflectionTestUtils.invokeMethod(productService, "convertToDto", products);

        // then
        assertNotNull(productDtoList);
        assertFalse(productDtoList.isEmpty());
        assertEquals(productDtoList.get(0).getName(), productDto.getName());
        assertEquals(productDtoList.get(0).getCategoryName(), productDto.getCategoryName());
    }
}
