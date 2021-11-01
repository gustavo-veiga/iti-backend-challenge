package itau.iti.challenge.validation;

import static itau.iti.challenge.helper.AssertionsHelper.assertInvalid;
import static itau.iti.challenge.helper.AssertionsHelper.assertValid;

import itau.iti.challenge.validation.constraints.Password;
import lombok.Value;
import org.junit.jupiter.api.Test;

class PasswordValidatorTest {
    @Test
    void hasPasswordValid() {
        assertValid(new ValidatePassword("AbTp9!fok"));
        assertValid(new ValidatePassword("AbTp9!fok80We"));
    }

    @Test
    void noHasPasswordValid() {
        assertInvalid(new ValidatePassword(""));
        assertInvalid(new ValidatePassword("aa"));
        assertInvalid(new ValidatePassword("ab"));
        assertInvalid(new ValidatePassword("AAAbbbCc"));
        assertInvalid(new ValidatePassword("AbTp9!foo"));
        assertInvalid(new ValidatePassword("AbTp9!foA"));
        assertInvalid(new ValidatePassword("AbTp9 fok"));
    }

    @Value
    private static class ValidatePassword {
        @Password
        String password;
    }
}
