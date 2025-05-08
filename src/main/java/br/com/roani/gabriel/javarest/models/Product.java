package br.com.roani.gabriel.javarest.models;

import java.math.BigDecimal;
import java.util.UUID;

import br.com.roani.gabriel.javarest.models.enums.CategoryEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    @Column
    private Integer multiplier;

    @Column(precision = 2, scale = 2)
    private BigDecimal price;

    @Column
    private Boolean hidden;

    @Column
    private Boolean available;
}
