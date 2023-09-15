package ada.poo02.projeto.controllers;

import ada.poo02.projeto.models.VehicleModel;
import ada.poo02.projeto.services.VehiclesService;

import java.util.List;

public class VehiclesController {
    private VehiclesService vehiclesService;

    public VehiclesController() {
        this.vehiclesService = new VehiclesService();
    }
    
    public void createNewVehicle(VehicleModel newVehicle) {
        this.vehiclesService.addVehicle(newVehicle);
    }

    public List<VehicleModel> listVehicles() {
        return this.vehiclesService.getAllVehicles();
    }

    public List<VehicleModel> listVehiclesByName(String name) {
        return this.vehiclesService.getAllVehiclesByName(name);
    }

    public List<VehicleModel> listVehiclesNotRented() {
        return this.vehiclesService.getAllVehicles(false);
    }

    public VehicleModel getVehicleById(long id) {
        return this.vehiclesService.getVehicleById(id);
    }

    public void updateVehicleByIdAndType(long id, VehicleModel vehicleToUpdate) {
        this.vehiclesService.updateVehicle(id, vehicleToUpdate);
    }
    public void updateVehicle(VehicleModel vehicleToUpdate) {
        this.vehiclesService.updateVehicle(vehicleToUpdate);
    }
}
