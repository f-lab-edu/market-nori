package spring.marketnori.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p from Product p WHERE p.name LIKE CONCAT('%', :keyword, '%')")
    List<Product> findProductBy(@Param("keyword") String keyword);
}
