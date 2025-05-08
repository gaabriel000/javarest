package br.com.roani.gabriel.javarest.models.params;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductParam {
    private String id;
    private String name;
    private Integer multiplier;
    private BigDecimal price;
    private Boolean isHidden;
    private Boolean isAvailable;
}
