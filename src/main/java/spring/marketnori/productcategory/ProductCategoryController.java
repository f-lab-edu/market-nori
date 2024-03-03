package spring.marketnori.productcategory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.marketnori.productcategory.dto.ProductListResponse;


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
    public ProductListResponse listProducts() {
        ProductListResponse productListResponse = new ProductListResponse();
        productListResponse.setCategories(productCategoryService.findProductsByCategory());

        return productListResponse;
    }

}
