package br.com.roani.gabriel.javarest.utils.mappers;

import br.com.roani.gabriel.javarest.models.Product;
import br.com.roani.gabriel.javarest.models.dtos.ProductDTO;

public class ProductMapper {
    public static Product toModel(ProductDTO dto) {
        if (dto == null) {
            return null;
        }

        Product model = new Product();
        model.setName(dto.getName());
        model.setDescription(dto.getDescription());
        model.setCategory(dto.getCategory());
        model.setMultiplier(dto.getMultiplier());
        model.setPrice(dto.getPrice());
        model.setHidden(dto.getHidden());
        model.setAvailable(dto.getAvailable());

        return model;
    }
}
