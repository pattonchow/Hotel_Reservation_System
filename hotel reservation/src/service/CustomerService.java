package service;

import model.Customer;
import model.Reservation;

import java.util.*;

public class CustomerService {

    private static Collection<Customer> customers = new LinkedList<>();

    public static void addCustomer(String email, String firstName, String lastName){
        customers.add(new Customer(firstName, lastName, email));
    }

    public static Customer getCustomer(String customerEmail){
        Customer theCustomer = null;
        for(Customer customer:customers){
            if (customer.getEmail().equals(customerEmail)){
                theCustomer = customer;
            }
        }
        return theCustomer;
    }

    public static Collection<Customer> getAllCustomers(){
        return customers;
    }
}
