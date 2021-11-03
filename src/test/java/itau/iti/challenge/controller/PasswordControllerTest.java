package itau.iti.challenge.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import itau.iti.challenge.dto.DPasswordValidateRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class PasswordControllerTest {
    private static final String URL = "/password/validate";
    private static final String JSON_EXPRESSION = "$.isValid";

    @Autowired
    private MockMvc mvc;

    public static String body(String password) throws JsonProcessingException {
        var validate = new DPasswordValidateRequest();
        validate.setPassword(password);
        return new ObjectMapper()
            .writeValueAsString(validate);
    }

    public void validate(String password, boolean expected) throws Exception {
        mvc.perform(post(URL)
                .content(body(password))
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath(JSON_EXPRESSION).value(expected));
    }

    @Test
    void withoutBodyHasBadRequest() throws Exception {
        mvc.perform(post(URL)
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON))
            .andExpect(status().isBadRequest());
    }

    @Test
    void validatePasswords() throws Exception {
        validate("", false);
        validate("aa", false);
        validate("ab", false);
        validate("AAAbbbCc", false);
        validate("AbTp9!foo", false);
        validate("AbTp9!foA", false);
        validate("AbTp9 fok", false);
        validate("AbTp9!fok", true);
        validate("AbTp9!fok80We", true);
    }
}
