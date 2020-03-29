package com.epam.brest.courses.web_app.validators;

import com.epam.brest.courses.model.Dress;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import static com.epam.brest.courses.constants.DressConstants.DRESS_NAME_SIZE;

/**
 * This class validate dress objects.
 */
@Component
public class DressValidator implements Validator {

    /**
     * Can this Validator validate instances of the supplied clazz?
     *
     * @param clazz the Class that this Validator
     * is being asked if it can validate
     * @return true if this Validator can indeed
     * validate instances of the supplied clazz.
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return Dress.class.equals(clazz);
    }

    /**
     * Validate the supplied target object,
     * which must be of a Class for which the supports(Class) method
     * typically has (or would) return true.
     *
     * @param target the object that is to be validated.
     * @param errors contextual state about the validation process.
     */
    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,
                "dressName", "dressName.empty");
        Dress dress = (Dress) target;

        if (StringUtils.hasLength(dress.getDressName())
                && dress.getDressName().length() > DRESS_NAME_SIZE) {
            errors.rejectValue("dressName",
                    "dressName.maxSize");
        }
    }
}
