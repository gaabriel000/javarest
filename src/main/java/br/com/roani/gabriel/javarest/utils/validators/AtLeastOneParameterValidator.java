package br.com.roani.gabriel.javarest.utils.validators;

import br.com.roani.gabriel.javarest.models.params.ProductParam;
import br.com.roani.gabriel.javarest.utils.validators.annotations.AtLeastOneParameter;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

public class AtLeastOneParameterValidator implements ConstraintValidator<AtLeastOneParameter, ProductParam> {

    @Override
    public boolean isValid(ProductParam param, ConstraintValidatorContext context) {
        if (param == null) {
            return false;
        }

        return StringUtils.isNotBlank(param.getName()) ||
               ObjectUtils.isNotEmpty(param.getCategory()) ||
               ObjectUtils.isNotEmpty(param.getPrice()) ||
               ObjectUtils.isNotEmpty(param.getHidden()) ||
               ObjectUtils.isNotEmpty(param.getAvailable());
    }
}