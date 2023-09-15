package ada.poo02.projeto.repositories;

import ada.poo02.projeto.models.CustomerModel;

import java.util.ArrayList;
import java.util.List;

public class CustomersRepository implements Repository<CustomerModel> {
    private final List<CustomerModel> customers;

    public CustomersRepository() {
        this.customers = new ArrayList<>();
    }

    @Override
    public CustomerModel findOneById(long id) {
        // return customers.get(id);
        return customers
                .stream()
                .filter(customer -> customer.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<CustomerModel> findAll() {
        return customers;
    }

    @Override
    public CustomerModel create(CustomerModel newCustomer) {
        customers.add(newCustomer);

        return newCustomer;
    }

    @Override
    public void deleteByType(CustomerModel customerToDelete) {
        customers.remove(customerToDelete);
    }

    @Override
    public void deleteById(long index) {
        // TODO: rever isso aqui.
    }

    @Override
    public CustomerModel updateByType(CustomerModel object) {
        // TODO: rever isso aqui.
        return null;
    }

    @Override
    public CustomerModel updateByIdAndType(int index, CustomerModel customer) {
        return customers.set(index, customer);
    }
}
