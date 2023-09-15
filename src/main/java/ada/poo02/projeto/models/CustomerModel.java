package ada.poo02.projeto.models;

import ada.poo02.projeto.models.enums.RegistrationType;

import lombok.Getter;
import lombok.Setter;

@Getter
public class CustomerModel {
    private static long countCustomer = 1;
    private final Long id;
    private @Setter String name;
    private @Setter String address;
    private @Setter RegistrationType registrationType;
    private @Setter String registrationNumber;

    public CustomerModel(
            String name,
            String address,
            RegistrationType registrationType,
            String registrationNumber
    ) {
        this.id = countCustomer++;
        this.name = name;
        this.address = address;
        this.registrationType = registrationType;
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String toString() {
        return "Cliente '" + name +
                "' do ID = " + id +
                ", endereço = '" + address +
                "', tipo de registro = '" + registrationType +
                "' e número de registro = '" + registrationNumber +
                "'.";
    }
}
