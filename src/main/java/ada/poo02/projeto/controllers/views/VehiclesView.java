package ada.poo02.projeto.controllers.views;

import ada.poo02.projeto.controllers.VehiclesController;
import ada.poo02.projeto.models.enums.VehiclesTypes;
import ada.poo02.projeto.models.VehicleModel;
import ada.poo02.projeto.utils.InputHandler;

import java.util.List;

public class VehiclesView {
    private VehiclesController vehiclesController;

    public VehiclesView() {
        this.vehiclesController = new VehiclesController();
    }
    
    public boolean createNewVehicle() {
        System.out.println("\n ----- Cadastro de veículo ----- \n");

        String model = InputHandler.getStringInput("Digite o modelo do veículo: ");
        String brand = InputHandler.getStringInput("Digite a marca do veículo: ");
        // TODO: garantir que vehicleType esteja em caixa alta.
        String vehicleType = InputHandler.getStringInput("Digite o tipo do veículo (PEQUENO/MEDIO/SUV): ");
        String nameplate = InputHandler.getStringInput("Digite a placa do veículo: ");

        VehicleModel newVehicle = new VehicleModel(
                model,
                brand,
                VehiclesTypes.valueOf(vehicleType.toUpperCase()), 
                nameplate
        );
        vehiclesController.createNewVehicle(newVehicle);

        System.out.println("\nVeículo cadastrado com sucesso!\n");
        return true;
    }

    public boolean listOfVehicles() {
        System.out.println("\n -----  Lista dos veículos cadastrados  ----- \n");

        List<VehicleModel> listOfVehicles = vehiclesController.listVehicles();

        for ( VehicleModel vehicle : listOfVehicles ) {
            System.out.println(vehicle);
        }
        System.out.println("\n ------- \n");
        // this.list();
        return true;
    }

    /*public void list() {
        System.out.println("\n -----  Lista dos veículos cadastrados  ----- \n");

        List<VehicleModel> listOfVehicles = vehiclesController.listVehicles();

        for ( VehicleModel vehicle : listOfVehicles ) {
            System.out.println(vehicle);
        }
        System.out.println("\n ------- \n");
    }*/
    public void listNotRented() {
        System.out.println("\n -----  Lista dos veículos disponíveis para alugar  ----- \n");

        List<VehicleModel> vehiclesToRent = vehiclesController.listVehiclesNotRented();

        for ( VehicleModel vehicle : vehiclesToRent ) {
            System.out.println(vehicle);
        }
        System.out.println("\n ------- \n");
    }

    public boolean updateVehicle() {
        System.out.println("\n ----- Atualiza cadastro de veículo ----- \n");

        // TODO: talvez criar um menu do que se quer atualizar
        long id = InputHandler.getLongInput("Digite o ID do cliente que deseja atualizar: ");
        VehicleModel vehicleToUpdate = vehiclesController.getVehicleById(id);

        String model = InputHandler.getStringInput("Digite o modelo do veículo: ");
        String brand = InputHandler.getStringInput("Digite a marca do veículo: ");
        // TODO: garantir que vehicleType esteja em caixa alta.
        String vehicleType = InputHandler.getStringInput("Digite o tipo do veículo (PEQUENO/MEDIO/GRANDE): ");
        String nameplate = InputHandler.getStringInput("Digite a placa do veículo: ");

        // TODO: tratar quando input for vazio
        vehicleToUpdate.setModel(model);
        vehicleToUpdate.setBrand(brand);
        vehicleToUpdate.setType(VehiclesTypes.valueOf(vehicleType.toUpperCase()));
        vehicleToUpdate.setNameplate(nameplate);

        vehiclesController.updateVehicle(vehicleToUpdate);

        System.out.println("\nCliente atualizado com sucesso!\n");
        return true;
    }

    public boolean filterByModel() {
        String model = InputHandler.getStringInput("Digite o modelo que deseja buscar: ");
        List<VehicleModel> listOfVehicles = vehiclesController.listVehiclesByName(model);

        System.out.println("\n ----- Lista de veículos filtrado pelo modelo ----- \n");

        for ( VehicleModel vehicle : listOfVehicles ) {
            System.out.println(vehicle);
        }
        System.out.println("\n ------- \n");

        return true;
    }
}
