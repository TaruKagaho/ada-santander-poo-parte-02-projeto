package ada.poo02.projeto.controllers.views;

import ada.poo02.projeto.controllers.CustomersController;
import ada.poo02.projeto.controllers.RentalsController;
import ada.poo02.projeto.controllers.VehiclesController;
import ada.poo02.projeto.models.RentalModel;
import ada.poo02.projeto.models.VehicleModel;
import ada.poo02.projeto.repositories.CustomersRepository;
import ada.poo02.projeto.repositories.RentalsRepository;
import ada.poo02.projeto.repositories.VehiclesRepository;
import ada.poo02.projeto.services.CustomersService;
import ada.poo02.projeto.services.RentalsService;
import ada.poo02.projeto.services.VehiclesService;
import ada.poo02.projeto.utils.CurrencyFormatter;
import ada.poo02.projeto.utils.InputHandler;

import java.time.LocalDateTime;
import java.util.List;

import static ada.poo02.projeto.utils.DateHandler.createLocalDateTime;

public class RentalView {
    private final RentalsController rentalsController;
    private final CustomersView customersView;
    private final VehiclesView vehiclesView;
    private final VehiclesController vehiclesController;

    /*public RentalView() {
        this.rentalsController = new RentalsController();
        this.customersView = new CustomersView();
        this.vehiclesView = new VehiclesView();
        this.vehiclesController = new VehiclesController();
    }*/

    public RentalView(
            RentalsController rentalsController,
            CustomersView customersView,
            VehiclesView vehiclesView,
            VehiclesController vehiclesController
    ) {
        this.rentalsController = rentalsController;
        this.customersView = customersView;
        this.vehiclesView = vehiclesView;
        this.vehiclesController = vehiclesController;
    }

    public boolean createNewRental() {
        System.out.println("\n ----- Cadastro de aluguel de veículo ----- ");

        customersView.list();

        long customerId = InputHandler.getLongInput("Digite o ID do cliente: ");

        vehiclesView.listNotRented();

        long vehicleId = InputHandler.getLongInput("Digite o ID do veículo: ");
        VehicleModel vehicle = vehiclesController.getVehicleById(vehicleId);

        if(vehicle.isRented()) {
            System.out.println("\nVeículo já está alugado!\n");

            return true;
        }
        vehicle.setRented(true);

        String address = InputHandler.getStringInput("Digite endereço onde será alugado o veículo: ");
        String date = InputHandler.getStringInput("Digite o dia do aluguel do veículo (dd/mm/aaaa): ");
        String time = InputHandler.getStringInput("Digite o horário do aluguel do veículo (hh:mm): ");

        LocalDateTime dateTime = createLocalDateTime(date, time);

        RentalModel newRental = new RentalModel(
                customerId,
                vehicleId,
                dateTime,
                address
        );
        rentalsController.createNewRental(newRental);

        System.out.println("\nAluguel cadastrado com sucesso!\n");
        return true;
    }

    public boolean listOfRentals() {
        /*System.out.println("\n -----  Lista de aluguéis cadastrados  ----- \n");

        List<RentalModel> rentals = rentalController.listRentals();

        for ( RentalModel rental : rentals ) {
            System.out.println(rental);
        }
        System.out.println("\n ------- \n");*/
        this.list();
        return true;
    }
    // TODO: talvez usar o list Generic
    public void list() {
        System.out.println("\n -----  Lista de aluguéis cadastrados  ----- \n");

        List<RentalModel> rentals = rentalsController.listRentalsActive();

        for ( RentalModel rental : rentals ) {
            System.out.println(rental);
        }
        System.out.println("\n ------- \n");
    }

    public boolean endRental() {
        System.out.println("\n ----- Encerra um aluguel ----- \n");

        this.list();

        long id = InputHandler.getLongInput("Digite o ID do aluguel que deseja encerrar: ");
        // TODO: tratar quando data informada for menor que a data do início do aluguel
        String date = InputHandler.getStringInput("Digite o dia do aluguel do veículo (dd/mm/aaaa): ");
        // TODO: tratar quando mesmo dia do início do aluguel, porém horário menor
        String time = InputHandler.getStringInput("Digite o horário do aluguel do veículo (hh:mm): ");

        LocalDateTime dateTime = createLocalDateTime(date, time);

        double cost = rentalsController.closeRental(id, dateTime);
        System.out.println("\nO preço do aluguel foi de " + CurrencyFormatter.formatCurrency(cost) + ".\n");
        return true;
    }
}
