package itau.iti.challenge.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import itau.iti.challenge.dto.DPasswordValidateRequest;
import itau.iti.challenge.mapper.PasswordMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PasswordServiceTest {
    @Autowired
    private PasswordService passwordService;

    @Autowired
    private PasswordMapper passwordMapper;

    private boolean validate(String password) {
        var request = new DPasswordValidateRequest();
        request.setPassword(password);
        return passwordService.validatePassword(request).getIsValid();
    }

    @Test
    void hasInvalidPassword() {
        assertFalse(validate(""));
        assertFalse(validate("aa"));
        assertFalse(validate("ab"));
        assertFalse(validate("AAAbbbCc"));
        assertFalse(validate("AbTp9!foo"));
        assertFalse(validate("AbTp9!foA"));
        assertFalse(validate("AbTp9 fok"));

    }

    @Test
    void hasValidPassword() {
        assertTrue(validate("AbTp9!fok"));
        assertTrue(validate("AbTp9!fok80We"));
    }
}
