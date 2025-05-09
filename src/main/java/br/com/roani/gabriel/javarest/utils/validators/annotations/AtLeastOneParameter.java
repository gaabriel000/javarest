package br.com.roani.gabriel.javarest.utils.validators.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

import br.com.roani.gabriel.javarest.utils.validators.AtLeastOneParameterValidator;

@Documented
@Constraint(validatedBy = AtLeastOneParameterValidator.class)
@Target({ ElementType.TYPE }) // Aplica-se à classe
@Retention(RetentionPolicy.RUNTIME)
public @interface AtLeastOneParameter {
    String message() default "Pelo menos um parâmetro de busca deve ser fornecido.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
