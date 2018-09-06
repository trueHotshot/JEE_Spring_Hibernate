package pl.coderslab.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = OlderThanValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OlderThan {
    int value();

    String message() default  "{olderThan.error.message}";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
