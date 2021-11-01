package itau.iti.challenge.helper;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class AssertionsHelper {
    private static final Validator VALIDATOR = Validation
        .buildDefaultValidatorFactory()
        .getValidator();

    public static <T> void assertValid(T object) {
        Set<ConstraintViolation<T>> violations = VALIDATOR.validate(object);
        assertTrue(violations.isEmpty());
    }

    public static <T> void assertInvalid(T object) {
        Set<ConstraintViolation<T>> violations = VALIDATOR.validate(object);
        assertFalse(violations.isEmpty());
    }
}
