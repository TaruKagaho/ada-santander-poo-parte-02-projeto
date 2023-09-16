package ada.poo02.projeto.controllers;

import ada.poo02.projeto.models.CustomerModel;
import ada.poo02.projeto.services.CustomersService;

import java.util.List;

public class CustomersController {
    private final CustomersService customersService;

    public CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }
    /*public CustomersController() {
        this.customersService = new CustomersService();
    }*/

    public void createNewCustomer(CustomerModel newCustomer) {
        this.customersService.addCustomer(newCustomer);
    }

    public List<CustomerModel> listCustomers() {
        return this.customersService.getAllCustomers();
    }

    public CustomerModel getCustomerById(long id) {
        return this.customersService.getCustomerById(id);
    }

    public void updateCustomerByIdAndType(long id, CustomerModel customerToUpdate) {
        this.customersService.updateCustomer(id, customerToUpdate);
    }
    public void updateCustomer(CustomerModel customerToUpdate) {
        this.customersService.updateCustomer(customerToUpdate);
    }
}
