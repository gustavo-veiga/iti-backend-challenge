package itau.iti.challenge.mapper;

import itau.iti.challenge.dto.DPasswordValidate;
import itau.iti.challenge.dto.DPasswordValidateRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PasswordMapper {
    DPasswordValidate toDPasswordValidate(DPasswordValidateRequest request);
}
