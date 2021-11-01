package itau.iti.challenge.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DPasswordValidateResponse {
    private Boolean isValid;
}
