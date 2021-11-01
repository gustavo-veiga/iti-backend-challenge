package itau.iti.challenge.validation;

import static itau.iti.challenge.helper.AssertionsHelper.assertInvalid;
import static itau.iti.challenge.helper.AssertionsHelper.assertValid;

import itau.iti.challenge.validation.constraints.NoRepeatedCharacters;
import lombok.Value;
import org.junit.jupiter.api.Test;

class NoRepeatedCharactersValidatorTest {
    @Test
    void noHasRepeatedCharactersInDummyName() {
        assertValid(new Dummy("dumy"));
        assertValid(new Dummy("DuMy?"));
    }

    @Test
    void hasRepeatedCharactersInDummyName() {
        assertInvalid(new Dummy("Dummy"));
        assertInvalid(new Dummy("Dumyy"));
    }

    @Value
    private static class Dummy {
        @NoRepeatedCharacters
        String name;
    }
}
