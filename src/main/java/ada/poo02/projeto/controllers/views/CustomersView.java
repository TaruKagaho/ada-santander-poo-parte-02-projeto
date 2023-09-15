package ada.poo02.projeto.controllers.views;

import ada.poo02.projeto.controllers.CustomersController;
import ada.poo02.projeto.models.enums.RegistrationType;
import ada.poo02.projeto.models.CustomerModel;
import ada.poo02.projeto.utils.InputHandler;

import java.util.List;

public class CustomersView {
    private CustomersController customersController;

    public CustomersView() {
        this.customersController = new CustomersController();
    }

    public boolean createNewCustomer() {
        System.out.println("\n ----- Cadastro de cliente ----- \n");

        String name = InputHandler.getStringInput("Digite o nome do cliente: ");
        String address = InputHandler.getStringInput("Digite endereço de " + name + ": ");
        String registrationType = InputHandler.getStringInput("Digite CPF/CNPJ do " + name + ": ");
        String registrationNumber = InputHandler.getStringInput(
                "Digite número do documento informado anteriormente de " +
                        name + ": "
        );

        CustomerModel newCustomer = new CustomerModel(
                name,
                address,
                RegistrationType.valueOf(registrationType.toUpperCase()),
                registrationNumber
        );
        customersController.createNewCustomer(newCustomer);

        System.out.println("\nCliente cadastrado com sucesso!\n");
        return true;
    }

    public boolean listOfCustomers() {
        /*System.out.println("\n -----  Lista dos clientes cadastrados  ----- \n");

        List<CustomerModel> listOfCustomers = customersController.listCustomers();

        for ( CustomerModel customer : listOfCustomers ) {
            System.out.println(customer);
        }
        System.out.println("\n ------- \n");*/
        this.list();
        return true;
    }

    public void list() {
        System.out.println("\n -----  Lista dos clientes cadastrados  ----- \n");

        List<CustomerModel> listOfCustomers = customersController.listCustomers();

        for ( CustomerModel customer : listOfCustomers ) {
            System.out.println(customer);
        }
        System.out.println("\n ------- \n");
    }

    public boolean updateCustomer() {
        System.out.println("\n ----- Atualiza cadastro de cliente ----- \n");

        // TODO: talvez criar um menu do que se quer atualizar
        long id = InputHandler.getLongInput("Digite o ID do cliente que deseja atualizar: ");
        CustomerModel customerToUpdate = customersController.getCustomerById(id);

        String name = InputHandler.getStringInput("Digite o nome do cliente: ");
        String address = InputHandler.getStringInput("Digite endereço de " + name + ": ");
        String registrationType = InputHandler.getStringInput("Digite CPF/CNPJ do " + name + ": ");
        String registrationNumber = InputHandler.getStringInput(
                "Digite número do documento informado anteriormente de " +
                        name + ": "
        );
        // TODO: tratar quando input for vazio
        customerToUpdate.setName(name);
        customerToUpdate.setAddress(address);
        customerToUpdate.setRegistrationType(RegistrationType.valueOf(registrationType.toUpperCase()));
        customerToUpdate.setRegistrationNumber(registrationNumber);

        customersController.updateCustomer(customerToUpdate);

        System.out.println("\nCliente atualizado com sucesso!\n");
        return true;
    }
}
