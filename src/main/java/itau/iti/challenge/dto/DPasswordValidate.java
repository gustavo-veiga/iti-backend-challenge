package itau.iti.challenge.dto;

import itau.iti.challenge.validation.constraints.Password;
import lombok.Data;

@Data
public class DPasswordValidate {
    @Password
    private String password;
}
