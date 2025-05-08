package br.com.roani.gabriel.javarest.models.dtos;

import java.math.BigDecimal;

import br.com.roani.gabriel.javarest.models.enums.CategoryEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private String name;
    private String description;
    private CategoryEnum category;
    private Integer multiplier;
    private BigDecimal price;
    private Boolean hidden;
    private Boolean available;
}
