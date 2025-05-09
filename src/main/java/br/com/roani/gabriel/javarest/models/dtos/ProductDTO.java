package br.com.roani.gabriel.javarest.models.dtos;

import java.math.BigDecimal;

import br.com.roani.gabriel.javarest.models.enums.CategoryEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    @NotBlank(message = "Name must not be null or empty")
    private String name;
    private String description;
    @NotBlank(message = "Category must not be null or empty")
    private CategoryEnum category;
    @Positive(message = "Multiplier must be a positive number")
    private Integer multiplier = 1;
    @Positive(message = "Price must be a positive number")
    private BigDecimal price;
    private Boolean hidden = false;
    private Boolean available = false;
}
