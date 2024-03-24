package spring.marketnori.product;

import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.marketnori.product.dto.ProductsResponse;

import java.util.List;

@Controller
@Slf4j
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/v1/search")
    @ResponseBody
    public ResponseEntity<ProductsResponse> getProductList(@RequestParam(name = "keyword", required = false) String keyword) {
        try {
            ProductsResponse productsResponse = new ProductsResponse();

            if (StringUtils.isEmpty(keyword)) {
                log.error("The keyword is empty.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }

            List<ProductsResponse.ProductDto> products = productService.findProductsByKeyword(keyword);
            if (products.isEmpty()) {
                log.debug("The product is empty.");
                return ResponseEntity.noContent().build();
            }

            productsResponse.setProductDtoList(products);

            return ResponseEntity.ok(productsResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
