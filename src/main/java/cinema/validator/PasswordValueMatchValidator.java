package cinema.validator;

import com.cinema.lib.FieldsValueMatch;
import com.cinema.model.dto.user.UserRegistrationDto;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValueMatchValidator implements
        ConstraintValidator<FieldsValueMatch, UserRegistrationDto> {

    private String field;
    private String fieldMatch;

    public void initialize(FieldsValueMatch constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatch();
    }

    public boolean isValid(UserRegistrationDto value,
                           ConstraintValidatorContext context) {
        Object fieldValue = new BeanWrapperImpl(value)
                .getPropertyValue(field);
        Object fieldMatchValue = new BeanWrapperImpl(value)
                .getPropertyValue(fieldMatch);
        return fieldValue != null ? fieldValue.equals(fieldMatchValue) : fieldMatchValue == null;
    }
}
