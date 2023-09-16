package ada.poo02.projeto;


import ada.poo02.projeto.controllers.CustomersController;
import ada.poo02.projeto.controllers.MenuController;
import ada.poo02.projeto.controllers.RentalsController;
import ada.poo02.projeto.controllers.VehiclesController;
import ada.poo02.projeto.controllers.views.CustomersView;
import ada.poo02.projeto.controllers.views.RentalView;
import ada.poo02.projeto.controllers.views.VehiclesView;
import ada.poo02.projeto.repositories.CustomersRepository;
import ada.poo02.projeto.repositories.RentalsRepository;
import ada.poo02.projeto.repositories.VehiclesRepository;
import ada.poo02.projeto.services.CustomersService;
import ada.poo02.projeto.services.RentalsService;
import ada.poo02.projeto.services.VehiclesService;

public class Main {
    public static void main(String[] args) {
        MenuController menuController = new MenuController(
                new CustomersView(
                        new CustomersController(
                                new CustomersService(
                                        new CustomersRepository()
                                )
                        )
                ),
                new VehiclesView(
                        new VehiclesController(
                                new VehiclesService(
                                        new VehiclesRepository()
                                )
                        )
                ),
                new RentalView(
                        new RentalsController(
                                new RentalsService(
                                        new RentalsRepository(),
                                        new CustomersService(
                                                new CustomersRepository()
                                        ),
                                        new VehiclesService(
                                                new VehiclesRepository()
                                        )
                                )
                        ),
                        new CustomersView(
                                new CustomersController(
                                        new CustomersService(
                                                new CustomersRepository()
                                        )
                                )
                        ),
                        new VehiclesView(
                                new VehiclesController(
                                        new VehiclesService(
                                                new VehiclesRepository()
                                        )
                                )
                        ),
                        new VehiclesController(
                                new VehiclesService(
                                        new VehiclesRepository()
                                )
                        )
                )
        );

        boolean keep = true;

        System.out.println("Bem vindo a plataforma de aluguel de carro!");

        while (keep) {
            keep = menuController.execute();
        }
    }
}