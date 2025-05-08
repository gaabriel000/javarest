package br.com.roani.gabriel.javarest.services;

import java.util.List;
import java.util.UUID;

import br.com.roani.gabriel.javarest.models.Product;
import br.com.roani.gabriel.javarest.models.dtos.ProductDTO;
import br.com.roani.gabriel.javarest.models.params.ProductParam;

public interface ProductService {
    List<Product> query(ProductParam params);
    Product create(ProductDTO productDTO);
    Product update(UUID id, ProductDTO productDTO);
    Boolean delete(UUID id);
}
