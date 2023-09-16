package ada.poo02.projeto.controllers;

import ada.poo02.projeto.models.RentalModel;
import ada.poo02.projeto.services.RentalsService;

import java.time.LocalDateTime;
import java.util.List;

public class RentalsController {
    private final RentalsService rentalsService;

    /*public RentalsController() {
        this.rentalsService = new RentalsService();
    }*/

    public RentalsController(RentalsService rentalsService) {
        this.rentalsService = rentalsService;
    }

    public void createNewRental(RentalModel newRental) {
        this.rentalsService.addRental(newRental);
    }

    public List<RentalModel> listRentalsActive() {
        return this.rentalsService.getAllRentalsActive();
    }

    public double closeRental(long id) {
        return this.rentalsService.finishRental(id);
    }
    public double closeRental(long id, LocalDateTime dateTime) {
        return this.rentalsService.finishRental(id, dateTime);
    }
}
