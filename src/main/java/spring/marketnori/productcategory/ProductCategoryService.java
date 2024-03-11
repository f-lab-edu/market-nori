package spring.marketnori.productcategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.marketnori.productcategory.dto.ProductListResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    public List<ProductListResponse.ProductCategoryDto> findProductsByCategory() {
        return convertToDto(productCategoryRepository.findAllCategoriesWithProducts());
    }

    private List<ProductListResponse.ProductCategoryDto> convertToDto(List<ProductCategory> productCategories) {
        return productCategories.stream()
                .map(productCategory -> new ProductListResponse.ProductCategoryDto(productCategory))
                .collect(Collectors.toList());
    }
}
