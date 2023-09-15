package ada.poo02.projeto.controllers;

import ada.poo02.projeto.controllers.views.CustomersView;
import ada.poo02.projeto.controllers.views.RentalView;
import ada.poo02.projeto.controllers.views.VehiclesView;

import static ada.poo02.projeto.controllers.views.MenuView.show;
import static ada.poo02.projeto.controllers.views.MenuView.tryAgain;

public class MenuController {
    private CustomersView customersView;
    private VehiclesView vehiclesView;
    private RentalView rentalView;

    public MenuController() {
        this.customersView = new CustomersView();
        this.vehiclesView = new VehiclesView();
        this.rentalView = new RentalView();
    }

    public boolean execute() {
        int option = show();

        return switch (option) {
            case 0 -> false;
            case 1 -> customersView.createNewCustomer();
            case 2 -> customersView.listOfCustomers();
            case 3 -> customersView.updateCustomer();
            case 4 -> vehiclesView.createNewVehicle();
            case 5 -> vehiclesView.listOfVehicles();
            case 6 -> vehiclesView.updateVehicle();
            case 7 -> vehiclesView.filterByModel();
            case 8 -> rentalView.createNewRental();
            case 9 -> rentalView.listOfRentals();
            case 10 -> rentalView.endRental();
            default -> tryAgain();
        };
    }
}
