package ada.poo02.projeto.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static ada.poo02.projeto.utils.DateHandler.formatDateToString;

@Getter
public class RentalModel {
    private static long countRental = 1;
    private final Long id;
    private Long customerId;
    private Long vehicleId;
    private LocalDateTime dateTime;
    private String address;
    private @Setter boolean active;

    public RentalModel(Long customerId, Long vehicleId, LocalDateTime dateTime, String address) {
        this.id = countRental++;
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.dateTime = dateTime;
        this.address = address;
        this.active = true;
    }

    @Override
    public String toString() {
        return "Aluguel "+ id +
                " {" +
                "clienteId = " + customerId +
                ", veículoId = " + vehicleId +
                ", data e horário = " + formatDateToString(dateTime) +
                ", local do aluguel = '" + address +
                "', ativo = " + active +
                " }";
    }
}
