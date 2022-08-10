package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.RoomType;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;


public class AdminResource {

    public static Customer getCustomer(String email){
        return CustomerService.getCustomer(email);
    }

    public static void addRoom(String roomNumber, double price, RoomType roomType) {
        ReservationService.addRoom(roomNumber, price, roomType);
    }

    public static Collection<IRoom> getAllRooms(){
        return ReservationService.allRooms();
    }

    public static Collection<Customer> getAllCustomers(){
        return CustomerService.getAllCustomers();
    }

    public static void displayAllReservations(){
        ReservationService.printAllReservation();
    }
}
