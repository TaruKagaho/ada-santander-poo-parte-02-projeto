package ada.poo02.projeto.models.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RegistrationType {
    CPF("CPF"),
    CNPJ("CNPJ");

    private final String registrationType;
}
