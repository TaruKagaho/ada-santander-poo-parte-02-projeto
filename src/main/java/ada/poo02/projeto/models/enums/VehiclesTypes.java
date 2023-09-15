package ada.poo02.projeto.models.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum VehiclesTypes {
    PEQUENO("PEQUENO", 100.0),
    MEDIO("MEDIO", 150.0),
    SUV("SUV", 200.0);

    private final String type;
    private final double pricePerDay;

    /*VehiclesTypes(String type, double pricePerDay) {
        this.type = type;
        this.pricePerDay = pricePerDay;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }*/

    /*PEQUENO("pequeno"),
    MEDIO("médio"),
    SUV("SUV");

    private final String vehicleType;


    VehiclesTypes(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }*/
}
