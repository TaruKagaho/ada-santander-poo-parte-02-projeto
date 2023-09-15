package ada.poo02.projeto.services;

import ada.poo02.projeto.models.CustomerModel;
import ada.poo02.projeto.models.RentalModel;
import ada.poo02.projeto.models.VehicleModel;
import ada.poo02.projeto.repositories.RentalsRepository;
import ada.poo02.projeto.utils.CalculateExpenses;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RentalsService {
    private static RentalsRepository rentalsRepository;
    private CustomersService customersService;
    private VehiclesService vehiclesService;

    public RentalsService() {
        rentalsRepository = new RentalsRepository();
        this.customersService = new CustomersService();
        this.vehiclesService = new VehiclesService();
    }

    private RentalModel getRentalById(long id) {
        RentalModel rentalFound = rentalsRepository.findOneById(id);

        if (rentalFound == null) {
            System.out.println("Aluguel não encontrado!");

            throw new RuntimeException("Aluguel não encontrado!");
        }

        return rentalFound;
    }

    public void addRental(RentalModel newRental) {
        rentalsRepository.create(newRental);
    }

    /*public List<RentalModel> getAllRentals() {
        return rentalsRepository.findAll();
    }*/
    public List<RentalModel> getAllRentalsActive() {
        List<RentalModel> rentals = rentalsRepository.findAll();
        List<RentalModel> rentalsActive = new ArrayList<>();

        for ( RentalModel rental : rentals ) {
            if (rental.isActive()) {
                rentalsActive.add(rental);
            }
        }

        return rentalsActive;
    }

    private void updateRentalActiveStatus(RentalModel rentalToUpdate) {

        List<RentalModel> vehicles = getAllRentalsActive();
        int index = vehicles.indexOf(rentalToUpdate);

        rentalToUpdate.setActive(false);

        rentalsRepository.updateByIdAndType(index, rentalToUpdate);
    }

    public double finishRental(long id) {
        RentalModel rentalToEnd = getRentalById(id);

        return 0.0;
    }
    public double finishRental(long id, LocalDateTime dateTime) {
        RentalModel rentalToEnd = getRentalById(id);
        CustomerModel customer = customersService.getCustomerById(rentalToEnd.getCustomerId());
        VehicleModel vehicleRented = vehiclesService.getVehicleById(rentalToEnd.getVehicleId());

        updateRentalActiveStatus(rentalToEnd);

        return CalculateExpenses.calculateExpenses(
                rentalToEnd.getDateTime(),
                dateTime,
                vehicleRented.getType().getPricePerDay(),
                customer.getRegistrationType().name()
        );
    }
}
