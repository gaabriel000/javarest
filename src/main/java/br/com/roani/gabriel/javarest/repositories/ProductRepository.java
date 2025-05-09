package br.com.roani.gabriel.javarest.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.roani.gabriel.javarest.models.Product;
import br.com.roani.gabriel.javarest.models.enums.CategoryEnum;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Query("SELECT p FROM Product p WHERE " +
            "(:id is null or p.id = :id) AND " +
            "(:name is null or lower(p.name) like lower(concat('%', :name, '%'))) AND " +
            "(:category is null or p.category = :category) AND " +
            "(:multiplier is null or p.multiplier = :multiplier) AND " +
            "(:price is null or p.price = :price) AND " +
            "(:hidden is null or p.hidden = :hidden) AND " +
            "(:available is null or p.available = :available)")
    List<Product> query(@Param("id") UUID id,
            @Param("name") String name,
            @Param("category") CategoryEnum category,
            @Param("multiplier") Integer multiplier,
            @Param("price") BigDecimal price,
            @Param("hidden") Boolean hidden,
            @Param("available") Boolean available);
}
