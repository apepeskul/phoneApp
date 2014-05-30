package com.apepeskul.service.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = { UniqueValidator.class })
@Target({ METHOD, ANNOTATION_TYPE, FIELD })
@Retention(RUNTIME)
public @interface UniqueColumn {
    String message() default "Already exists";

    String property();

    Class<?> entity();

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
