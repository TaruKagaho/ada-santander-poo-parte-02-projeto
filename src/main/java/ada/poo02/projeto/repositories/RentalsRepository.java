package ada.poo02.projeto.repositories;

import ada.poo02.projeto.models.RentalModel;

import java.util.ArrayList;
import java.util.List;

public class RentalsRepository implements Repository<RentalModel>{
    private final List<RentalModel> rentals;

    public RentalsRepository() {
        this.rentals = new ArrayList<>();
    }

    @Override
    public RentalModel findOneById(long id) {
        return rentals
                .stream()
                .filter(rental -> rental.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<RentalModel> findAll() {
        return rentals;
    }

    @Override
    public RentalModel create(RentalModel newRental) {
        rentals.add(newRental);

        return newRental;
    }

    @Override
    public void deleteByType(RentalModel object) {

    }

    @Override
    public void deleteById(long id) {}

    @Override
    public RentalModel updateByType(RentalModel object) {
        return null;
    }

    @Override
    public RentalModel updateByIdAndType(int index, RentalModel rentalToUpdate) {
        return rentals.set(index, rentalToUpdate);
    }
}
