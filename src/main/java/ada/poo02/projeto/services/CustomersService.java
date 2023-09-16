package ada.poo02.projeto.services;

import ada.poo02.projeto.models.CustomerModel;
import ada.poo02.projeto.repositories.CustomersRepository;

import java.util.ArrayList;
import java.util.List;

public class CustomersService {
    private static CustomersRepository customersRepository;

    /*public CustomersService() {
        customersRepository = new CustomersRepository();
    }*/

    public CustomersService(CustomersRepository customersRepository) {
        CustomersService.customersRepository = customersRepository;
    }

    // TODO: talvez mover método de validar documento para pasta utils
    private boolean isRegistrationNumberAlreadyRegistered(String resgistrationNumber, boolean isUpdate) {
        List<CustomerModel> customersRegistered = customersRepository.findAll();

        if (!customersRegistered.isEmpty()) {
            // List<CustomerModel> customers;
            List<CustomerModel> customers = new ArrayList<>();

            /*if (isUpdate) {
                customers = customersRegistered
                        .stream()
                        .filter(
                                customer -> !customer.getRegistrationNumber().equalsIgnoreCase(resgistrationNumber)
                        )
                        .toList();
            } else {
                customers = customersRegistered;
            }*/
            /*if (isUpdate) {
                Stream<CustomerModel> customersFiltered = customersRegistered
                        .stream()
                        .filter(
                                customer -> !customer.getRegistrationNumber().equalsIgnoreCase(resgistrationNumber)
                        );

                if (customersFiltered.findFirst().isPresent()) {
                    return true;
                } else {
                    customers = customersFiltered.toList();
                }
                for ( CustomerModel customer : customersRegistered ) {
                    if (!customer.getRegistrationNumber().equalsIgnoreCase(resgistrationNumber)) {
                        customers.add(customer);
                    }
                }
                for ( CustomerModel customer : customersRegistered ) {
                    if (customer.getRegistrationNumber().equalsIgnoreCase(resgistrationNumber)) {
                        return true;
                    }
                }

            } else {
                customers = customersRegistered;
            }*/

            /*for ( CustomerModel customer : customers ) {
                if (customer.getRegistrationNumber().equalsIgnoreCase(resgistrationNumber)) {
                    return true;
                }
            }*/
            for ( CustomerModel customer : customersRegistered ) {
                if (customer.getRegistrationNumber().equalsIgnoreCase(resgistrationNumber)) {
                    return true;
                }
            }
        }

        return false;
    }
    private boolean isRegistrationNumberAlreadyRegistered(CustomerModel customerToValidate, boolean isUpdate) {
        List<CustomerModel> customersRegistered = customersRepository.findAll();

        if (!customersRegistered.isEmpty()) {
            List<CustomerModel> customers;

            if (isUpdate) {
                customers = customersRegistered
                        .stream()
                        .filter(
                                customer -> !customer.getId().equals(customerToValidate.getId())
                        )
                        .toList();
            } else {
                customers = customersRegistered;
            }

            for ( CustomerModel customer : customers ) {
                if (customer.getRegistrationNumber().equalsIgnoreCase(customerToValidate.getRegistrationNumber())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addCustomer(CustomerModel newCustomer) {
        /*if (isResgistrationNumberAlreadyRegistered(
                newCustomer.getRegistrationNumber(),
                false
        )) {
            throw new RuntimeException("Número de registro já cadastrada!");
        }*/
        if (isRegistrationNumberAlreadyRegistered(
                newCustomer,
                false
        )) {
            // TODO: criar excessão quando documento já cadastrado
            throw new RuntimeException("Número de registro já cadastrada!");
        }
        
        customersRepository.create(newCustomer);
    }

    // TODO: fazer tratamento quando lista Clientes estiver vazia
    public List<CustomerModel> getAllCustomers() {
        return customersRepository.findAll();
    }

    public CustomerModel getCustomerById(long id) {
        CustomerModel customerFound = customersRepository.findOneById(id);

        if (customerFound == null) {
            System.out.println("Cliente não encontrado!");

            throw new RuntimeException("Cliente não encontrado!");
        }

        return customerFound;
    }

    public void updateCustomer(Long id, CustomerModel customerToUpdate) {
        // TODO: verificar ID também no Banco de Dados
        if (customerToUpdate.getId() != id) {
            // TODO: criar excessão específica
            throw new RuntimeException("O id informado é inválido!");
        }

        /*if (isResgistrationNumberAlreadyRegistered(
                customerToUpdate.getRegistrationNumber(),
                true
        )) {
            throw new RuntimeException("Número de registro já cadastrada!");
        }*/
        if (isRegistrationNumberAlreadyRegistered(
                customerToUpdate,
                true
        )) {
            throw new RuntimeException("Número de registro já cadastrada!");
        }

        List<CustomerModel> customers = getAllCustomers();
        /*CustomerModel customerOld = getCustomerById(id);
        int index = customers.indexOf(customerOld);*/
        int index = customers.indexOf(getCustomerById(id));

        // customersRepository.delete(customerOld);
        customersRepository.updateByIdAndType(index, customerToUpdate);
    }
    public void updateCustomer(CustomerModel customerToUpdate) {
        /*if (isResgistrationNumberAlreadyRegistered(
                customerToUpdate.getRegistrationNumber(),
                true
        )) {
            throw new RuntimeException("Número de registro já cadastrada!");
        }*/
        if (isRegistrationNumberAlreadyRegistered(
                customerToUpdate,
                true
        )) {
            // TODO: criar excessão para número do documento
            throw new RuntimeException("Número de registro já cadastrada!");
        }

        // List<CustomerModel> customers = getAllCustomers();
        /*CustomerModel customerOld = getCustomerById(id);
        int index = customers.indexOf(customerOld);*/
        // int index = customers.indexOf(getCustomerById(id));

        // customersRepository.delete(customerOld);
        // customersRepository.updateByIdAndType(index, customerToUpdate);
        customersRepository.updateByType(customerToUpdate);
    }
}
