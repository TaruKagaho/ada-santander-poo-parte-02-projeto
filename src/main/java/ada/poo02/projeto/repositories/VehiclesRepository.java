package ada.poo02.projeto.repositories;

import ada.poo02.projeto.models.VehicleModel;

import java.util.ArrayList;
import java.util.List;

public class VehiclesRepository implements Repository<VehicleModel> {
    private final List<VehicleModel> vehicles;

    public VehiclesRepository() {
        this.vehicles = new ArrayList<>();
    }

    @Override
    public VehicleModel findOneById(long id) {
        return vehicles
                .stream()
                .filter(vehicle -> vehicle.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<VehicleModel> findAll() {
        return vehicles;
    }

    @Override
    public VehicleModel create(VehicleModel newVehicle) {
        vehicles.add(newVehicle);

        return newVehicle;
    }

    @Override
    public void deleteByType(VehicleModel vehicleToDelete) {
        vehicles.remove(vehicleToDelete);
    }

    @Override
    public void deleteById(long id) {
        // TODO: rever isso aqui.
    }

    @Override
    public VehicleModel updateByType(VehicleModel object) {
        // TODO: rever isso aqui.
        return null;
    }

    @Override
    public VehicleModel updateByIdAndType(int index, VehicleModel vehicleToUpdate) {
        return vehicles.set(index, vehicleToUpdate);
    }
}
