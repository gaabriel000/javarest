package br.com.roani.gabriel.javarest.services.impl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import br.com.roani.gabriel.javarest.models.Product;
import br.com.roani.gabriel.javarest.models.dtos.ProductDTO;
import br.com.roani.gabriel.javarest.models.params.ProductParam;
import br.com.roani.gabriel.javarest.repositories.ProductRepository;
import br.com.roani.gabriel.javarest.services.ProductService;
import br.com.roani.gabriel.javarest.utils.mappers.ProductMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> query(ProductParam params) {
        return productRepository.query(
            params.getId(),
            params.getName(),
            params.getCategory(),
            params.getMultiplier(),
            params.getPrice(),
            params.getHidden(),
            params.getAvailable()
    );
    }

    @Override
    public Product create(ProductDTO productDTO) {
        Product product = ProductMapper.toModel(productDTO);
        return productRepository.saveAndFlush(product);
    }

    @Override
    public Product update(UUID id, ProductDTO productDTO) {
        Product product = findById(id);

        if (ObjectUtils.isEmpty(product)) {
            return null;
        }

        product = ProductMapper.toModel(productDTO);
        product.setId(id);
        return productRepository.saveAndFlush(product);
    }

    @Override
    public Boolean delete(UUID id) {
        Product product = findById(id);

        if (ObjectUtils.isEmpty(product)) {
            return false;
        }

        productRepository.delete(product);
        return true;
    }

    private Product findById(UUID id) {
        return productRepository.getReferenceById(id);
    }
}
