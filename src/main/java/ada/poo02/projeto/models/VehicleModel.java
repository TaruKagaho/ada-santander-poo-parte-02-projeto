package ada.poo02.projeto.models;

import ada.poo02.projeto.models.enums.VehiclesTypes;

import ada.poo02.projeto.utils.CurrencyFormatter;
import lombok.Getter;
import lombok.Setter;

@Getter
public class VehicleModel {
    private static long countVehicle = 1;
    private final Long id;
    private @Setter String model;
    private @Setter String brand;
    private @Setter VehiclesTypes type;
    private @Setter String nameplate;
    private @Setter boolean rented;

    public VehicleModel(
            String model,
            String brand,
            VehiclesTypes type,
            String nameplate
    ) {
        this.id = countVehicle++;
        this.model = model;
        this.brand = brand;
        this.type = type;
        this.nameplate = nameplate;
        this.rented = false;
    }

    @Override
    public String toString() {
        return "Veículo '" + model +
                "' de id = " + id +
                ", marca = '" + brand +
                "', tipo = '" + type +
                "', placa = '" + nameplate +
                "', valor da diária =  " + CurrencyFormatter.formatCurrency(type.getPricePerDay()) +
                " e alugado = '" + rented +
                "'.";
    }
}
