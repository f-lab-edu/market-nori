package spring.marketnori.productcategory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.marketnori.productcategory.dto.ProductListResponse;

import java.util.List;


@Slf4j
@Controller
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    @Autowired
    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @ResponseBody
    @GetMapping("/v1/products")
    public ResponseEntity<ProductListResponse> listProducts() {
        try {
            ProductListResponse productListResponse = new ProductListResponse();
            List<ProductListResponse.ProductCategoryDto> categories = productCategoryService.findProductsByCategory();

            if (categories.isEmpty()) {
                log.debug("The product list is empty.");
                return ResponseEntity.noContent().build();
            }

            productListResponse.setCategories(categories);
            return ResponseEntity.ok(productListResponse);
        } catch (Exception e) {
            log.error("Error retrieving product list", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
