package ada.poo02.projeto.controllers;

import ada.poo02.projeto.models.RentalModel;
import ada.poo02.projeto.services.RentalsService;

import java.time.LocalDateTime;
import java.util.List;

public class RentalsController {
    private final RentalsService rentalSService;

    public RentalsController() {
        this.rentalSService = new RentalsService();
    }

    public void createNewRental(RentalModel newRental) {
        this.rentalSService.addRental(newRental);
    }

    public List<RentalModel> listRentalsActive() {
        return this.rentalSService.getAllRentalsActive();
    }

    public double closeRental(long id) {
        return this.rentalSService.finishRental(id);
    }
    public double closeRental(long id, LocalDateTime dateTime) {
        return this.rentalSService.finishRental(id, dateTime);
    }
}
