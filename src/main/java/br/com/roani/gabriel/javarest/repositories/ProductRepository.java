package br.com.roani.gabriel.javarest.repositories;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.roani.gabriel.javarest.models.Product;
import br.com.roani.gabriel.javarest.models.params.ProductParam;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> query(ProductParam params);
}
