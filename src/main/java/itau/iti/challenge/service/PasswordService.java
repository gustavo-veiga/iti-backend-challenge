package itau.iti.challenge.service;

import itau.iti.challenge.dto.DPasswordValidate;
import itau.iti.challenge.dto.DPasswordValidateRequest;
import itau.iti.challenge.dto.DPasswordValidateResponse;
import itau.iti.challenge.mapper.PasswordMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class PasswordService {
    private final PasswordMapper mapper;
    private final Validator validator;

    @Cacheable
    public DPasswordValidateResponse validatePassword(DPasswordValidateRequest request) {
        DPasswordValidate validate = mapper.toDPasswordValidate(request);
        Set<ConstraintViolation<DPasswordValidate>> violations = validator.validate(validate);
        return DPasswordValidateResponse.builder()
            .isValid(violations.isEmpty())
            .build();
    }
}
