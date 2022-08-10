package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;
import java.util.regex.Pattern;

public class HotelResource {

    public static Customer getCustomer(String email){
        return getCustomer(email);
    }

    public static void createACustomer(String email, String firstName, String lastName){
        String emailRegex = "^(.+)@(.+).(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (pattern.matcher(email).matches()){
            CustomerService.addCustomer(firstName, lastName, email);
        }else{
            throw new IllegalArgumentException("Error, this is not an email");
        }
    }

    public static IRoom getRoom(String roomNumber){
        return ReservationService.getARoom(roomNumber);
    }

    public static Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){
        Customer customer = CustomerService.getCustomer(customerEmail);
        return (Reservation) ReservationService.getCustomersReservation(customer);
    }

    public static Collection<Reservation> getCustomersReservations(String customerEmail){
        Customer customer = CustomerService.getCustomer(customerEmail);
        return ReservationService.getCustomersReservation(customer);
    }

    public static Collection<IRoom> findARoom(Date checkInDate, Date checkOutDate){
        return ReservationService.findRooms(checkInDate, checkOutDate);
    }


}
