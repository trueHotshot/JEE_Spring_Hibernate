package pl.coderslab.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

public class OlderThanValidator implements ConstraintValidator<OlderThan, Integer> {
    private int minAge;
    @Override
    public void initialize(OlderThan ageParam) {
        minAge = ageParam.value();
    }

    @Override
    public boolean isValid(Integer yearOfBirth, ConstraintValidatorContext constraintValidatorContext) {
        int age = yearOfBirth == null ? 0 : LocalDateTime.now().getYear() - yearOfBirth;
        return age >= minAge;
    }
}
