package br.com.roani.gabriel.javarest.controllers;

import br.com.roani.gabriel.javarest.models.Product;
import br.com.roani.gabriel.javarest.models.dtos.ProductDTO;
import br.com.roani.gabriel.javarest.models.params.ProductParam;
import br.com.roani.gabriel.javarest.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public ResponseEntity<List<Product>> query(@Valid @RequestParam ProductParam param) {
        List<Product> products = productService.query(param);

        if (ObjectUtils.isEmpty(products)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<Product> create(@Valid @RequestBody ProductDTO body) {
        Product product = productService.create(body);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> update (@PathVariable UUID id, @Valid @RequestBody ProductDTO body) {
        Product product = productService.update(id, body);
        if (ObjectUtils.isEmpty(product)) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        Boolean succesfully = productService.delete(id);
        if (Boolean.TRUE.equals(succesfully)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                        errors.put(error.getField(), error.getDefaultMessage()));
        return errors;
    }
}
