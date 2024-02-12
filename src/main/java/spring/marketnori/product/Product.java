package spring.marketnori.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    private Long price;
    private Long stockQuantity;
    private LocalDate saleStartDate;
    private LocalDate saleEndDate;
    private Long categoryId;
}
