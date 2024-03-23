package spring.marketnori.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.marketnori.product.dto.ProductsResponse;
import spring.marketnori.product.mapper.ProductMapper;

import java.util.List;


@Service
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductMapper productMapper, ProductRepository productRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    public List<ProductsResponse.ProductDto> findProductsByKeyword(String keyword) {
        List<Product> products = productRepository.findProductBy(keyword);
        return convertToDto(products);
    }

    private List<ProductsResponse.ProductDto> convertToDto(List<Product> products) {
        return productMapper.productsToProductDtos(products);
    }
}
