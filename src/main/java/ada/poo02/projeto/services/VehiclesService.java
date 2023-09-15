package ada.poo02.projeto.services;

import ada.poo02.projeto.models.VehicleModel;
import ada.poo02.projeto.repositories.VehiclesRepository;

import java.util.ArrayList;
import java.util.List;

public class VehiclesService {
    private static VehiclesRepository vehiclesRepository;

    public VehiclesService() {
        vehiclesRepository = new VehiclesRepository();
    }

    private boolean isNameplateAlreadyRegistered(VehicleModel vehicleToValidate, boolean isUpdate) {
        List<VehicleModel> vehiclesRegistered = vehiclesRepository.findAll();

        if (!vehiclesRegistered.isEmpty()) {
            List<VehicleModel> vehicles;

            if (isUpdate) {
                vehicles = vehiclesRegistered
                        .stream()
                        .filter(
                                vehicle -> !vehicle.getId().equals(vehicleToValidate.getId())
                        )
                        .toList();
            } else {
                vehicles = vehiclesRegistered;
            }

            for ( VehicleModel vehicle : vehicles ) {
                if (vehicle.getNameplate().equalsIgnoreCase(vehicleToValidate.getNameplate())) {
                    return true;
                }
            }
        }

        return false;
    }

    public void addVehicle(VehicleModel newVehicle) {
        // TODO: criar excessão quando placa igual
        if (isNameplateAlreadyRegistered(newVehicle, false)) {
            throw new RuntimeException("Placa já cadastrada!");
        }

        vehiclesRepository.create(newVehicle);
    }
    // TODO: fazer tratamento quando lista Veículos estiver vazia
    public List<VehicleModel> getAllVehicles() {
        return vehiclesRepository.findAll();
    }
    public List<VehicleModel> getAllVehiclesByName(String name) {
        List<VehicleModel> vehiclesWithSameName = new ArrayList<>();
        List<VehicleModel> vehiclesRegistered = vehiclesRepository.findAll();

        for ( VehicleModel vehicle : vehiclesRegistered ) {
            /*if (vehicle.getModel().equalsIgnoreCase(name)) {
                vehiclesWithSameName.add(vehicle);
            }*/
            String vehicleModelLowerCase = vehicle.getModel().toLowerCase();
            String nameLowerCase = name.toLowerCase();

            if (vehicleModelLowerCase.contains(nameLowerCase)) {
                vehiclesWithSameName.add(vehicle);
            }
        }

        return vehiclesWithSameName;
    }
    public List<VehicleModel> getAllVehicles(boolean isRented) {
        List<VehicleModel> vehiclesNotRented = new ArrayList<>();
        List<VehicleModel> vehiclesRegistered = vehiclesRepository.findAll();

        for ( VehicleModel vehicle : vehiclesRegistered ) {
            if (!vehicle.isRented()) {
                vehiclesNotRented.add(vehicle);
            }
        }

        return vehiclesNotRented;
    }

    public VehicleModel getVehicleById(long id) {
        VehicleModel vehicleFound = vehiclesRepository.findOneById(id);
        // TODO: criar excessão específica para vehicleId
        if (vehicleFound == null) {
            System.out.println("Veículo não encontrado!");

            throw new RuntimeException("Veículo não encontrado!");
        }

        return vehicleFound;
    }

    public void updateVehicle(Long id, VehicleModel vehicleToUpdate) {
        if (!vehicleToUpdate.getId().equals(id)) {
            // TODO: criar excessão quando ID informado for diferente do veículo informado
            throw new RuntimeException("O id informado é inválido!");
        }

        if (isNameplateAlreadyRegistered(vehicleToUpdate, true)) {
            // TODO: riar excessão para quando a placa já estiver cadastrada
            throw new RuntimeException("Placa já cadastrada!");
        }

        List<VehicleModel> vehicles = getAllVehicles();
        int index = vehicles.indexOf(getVehicleById(id));

        vehiclesRepository.updateByIdAndType(index, vehicleToUpdate);
    }
    public void updateVehicle(VehicleModel vehicleToUpdate) {
        // TODO: criar excessão quando placa igual
        if (isNameplateAlreadyRegistered(vehicleToUpdate, true)) {
            throw new RuntimeException("Placa já cadastrada!");
        }

        vehiclesRepository.updateByType(vehicleToUpdate);
    }
}
