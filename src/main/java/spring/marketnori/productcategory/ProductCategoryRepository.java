package spring.marketnori.productcategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    @Query("SELECT c from ProductCategory c join fetch c.products")
    List<ProductCategory> findAllCategoriesWithProducts();
}
