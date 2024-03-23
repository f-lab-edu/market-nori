package spring.marketnori.product.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import spring.marketnori.product.Product;
import spring.marketnori.product.dto.ProductsResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    List<ProductsResponse.ProductDto> productsToProductDtos(List<Product> products);

    @Mapping(source = "productCategory.categoryName", target = "categoryName")
    ProductsResponse.ProductDto productToProductDto(Product product);
}
