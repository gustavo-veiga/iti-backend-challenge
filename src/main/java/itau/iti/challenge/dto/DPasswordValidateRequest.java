package itau.iti.challenge.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DPasswordValidateRequest {
    @NotNull
    private String password;
}
