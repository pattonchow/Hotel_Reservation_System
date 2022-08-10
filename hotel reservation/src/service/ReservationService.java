package service;

import model.*;

import java.util.*;

public class ReservationService {

   private static Collection<IRoom> rooms = new LinkedList<>();
   private static Collection<Reservation> reservations = new LinkedList<>();

   public static void addRoom(String roomNumber, double price, RoomType roomType){
       rooms.add(new Room(roomNumber, price, roomType));
   }

   public static IRoom getARoom(String roomId){
       IRoom theRoom = null;
       for (IRoom room : rooms){
           if (room.getRoomNumber().equals(roomId)){
               theRoom = room;
           }
       }
       return theRoom;
   }

   public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
       Reservation reservation = new Reservation(customer, room, checkInDate,checkOutDate);
       reservations.add(reservation);
       return reservation;
   }

   public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
       Collection<IRoom> availableRooms = new LinkedList<>();
       for (Reservation reservation : reservations){
           if (checkInDate.before(reservation.getCheckInDate())&&checkOutDate.before(reservation.getCheckInDate())){
               availableRooms.add(reservation.getRoom());
           }
           if (checkInDate.after(reservation.getCheckOutDate())){
               availableRooms.add(reservation.getRoom());
           }
       }
       if (availableRooms.isEmpty()){

       }
       return  availableRooms;
   }

   public static Collection<Reservation>getCustomersReservation(Customer customer){
       Collection customerReservations = new LinkedList();
       try{
           for(Reservation reservation : reservations){
               if(reservation.getCustomer().equals(customer)){
                   customerReservations.add(reservation);
               }
           }
       }catch (Exception ex){
           ex.printStackTrace();
           System.out.println("There is no reservations for this customer.");
       }
       return customerReservations;
   }

   public static void printAllReservation(){
       System.out.println(reservations);
   }
   
   public static Collection<Reservation> getAllReservations(){
       return reservations;
   }
   
   public static Collection<IRoom> allRooms(){
       return rooms;
   }


}
