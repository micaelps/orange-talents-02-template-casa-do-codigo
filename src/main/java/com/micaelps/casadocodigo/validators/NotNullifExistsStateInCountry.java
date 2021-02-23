package com.micaelps.casadocodigo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotNullifExistsStateInCountryValidator.class)
@Target({ElementType.TYPE})
@Documented
public @interface NotNullifExistsStateInCountry {

    String message() default "";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
