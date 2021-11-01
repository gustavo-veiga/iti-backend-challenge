package itau.iti.challenge;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class ChallengeApplicationTests {
    @Test
    void contextLoads() {
        assertDoesNotThrow(() -> ChallengeApplication.main(new String[]{}));
    }
}
