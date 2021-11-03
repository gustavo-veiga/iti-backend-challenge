package itau.iti.challenge.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import itau.iti.challenge.dto.DPasswordValidateRequest;
import itau.iti.challenge.dto.DPasswordValidateResponse;
import itau.iti.challenge.service.PasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Tag(name = "Password")
@RestController
@RequestMapping("/password")
@RequiredArgsConstructor
public class PasswordController {
    private final PasswordService passwordService;

    @PostMapping("/validate")
    public DPasswordValidateResponse validate(@Valid @RequestBody DPasswordValidateRequest request) {
        return passwordService.validatePassword(request);
    }
}
