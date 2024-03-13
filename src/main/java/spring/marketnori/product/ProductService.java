package spring.marketnori.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spring.marketnori.product.dto.ProductsResponse;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductsResponse.ProductDto> findProductsByKeyword(String keyword) throws Exception {
        List<Product> products;
        try {
            products = productRepository.findProductBy(keyword);
        } catch (Exception e) {
            log.error("Error while fetching products by keyword: {}", keyword, e);
            throw new Exception("Product search failed.",e);
        }
        return convertToDto(products);
    }

    private List<ProductsResponse.ProductDto> convertToDto(List<Product> products) {
        return products.stream()
                .map(ProductsResponse.ProductDto::new)
                .collect(Collectors.toList());
    }
}
