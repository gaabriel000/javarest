package br.com.roani.gabriel.javarest.models.params;

import java.math.BigDecimal;
import java.util.UUID;

import br.com.roani.gabriel.javarest.models.enums.CategoryEnum;
import br.com.roani.gabriel.javarest.utils.validators.annotations.AtLeastOneParameter;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AtLeastOneParameter
public class ProductParam {
    private UUID id;
    private String name;
    private CategoryEnum category;
    @Positive(message = "Multiplier must be a positive number")
    private Integer multiplier;
    @Positive(message = "Price must be a positive number")
    private BigDecimal price;
    private Boolean hidden;
    private Boolean available;
}
