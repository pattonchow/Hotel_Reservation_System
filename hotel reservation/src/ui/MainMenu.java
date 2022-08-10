package ui;

import api.HotelResource;
import model.Customer;
import model.IRoom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.StreamSupport;

public class MainMenu {

//    public static Scanner input;
    public static void displayMenu(){
        System.out.println("Welcome Hotel Reservation System");
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println("1. Find and reserve a room");
        System.out.println("2. See my reservations");
        System.out.println("3. Create an account");
        System.out.println("4. Admin");
        System.out.println("5. Exit");
        System.out.println("-------------------------------------------");
    }

    private static void findAndReserveARoom(){
        Date checkInDate = new Date();
        Date checkOutDate = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your check in date in DD/MM/YYYY format");
        String checkInString = scanner.next();
        try {
            checkInDate = formatter.parse(checkInString);
        }catch (ParseException e){
            e.printStackTrace();
        }
        System.out.println("Enter your check out date in DD/MM/YYYY format");
        String checkOutString = scanner.next();
        try {
            checkOutDate = formatter.parse(checkOutString);
        }catch (ParseException e){
            e.printStackTrace();
        }

        System.out.println("There are available rooms for you");
        System.out.println(HotelResource.findARoom(checkInDate, checkOutDate));

        System.out.println("Select one room and enter the room number: ");
        String roomNumber = scanner.next();
        IRoom room = HotelResource.getRoom(roomNumber);
        System.out.println(room);
        System.out.println(roomNumber);

        System.out.println("Please enter your email: ");
        String email = scanner.next();

        HotelResource.bookARoom(email,room,checkInDate,checkOutDate);
        System.out.println("Your reservation has been booked!");
        System.out.println(email + " " + room + " " + checkInDate + " " + checkOutDate);
    }

    private static void seeMyReservations(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter your Email");
        String email = scanner.next();
        System.out.println(HotelResource.getCustomersReservations(email));
    }

    private static Customer createAccount(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter your first name: ");
        String firstName = scanner.next();
        System.out.println("Please Enter your last name: ");
        String lastName = scanner.next();
        System.out.println("Please Enter your Email: ");
        String email = scanner.next();
        HotelResource.createACustomer(email, firstName, lastName);
        return new Customer(firstName,lastName,email);
    }

    public static void mainMenu(){
        displayMenu();
        Scanner input = new Scanner(System.in);
        int selection = input.nextInt();
        switch (selection){
            case 1:
                System.out.println("Your Selection is to make a new Reservation");
                findAndReserveARoom();
                break;

            case 2:
                System.out.println("Your Selection is to see your reservations");
                seeMyReservations();
                break;

            case 3:
                System.out.println("Your Selection is to Create a new Account");
                createAccount();
                break;

            case 4:
                System.out.println("Your selection is to back to the Admin menu");
//                AdminMenu.startAdmin();
                return;

            case 5:
                input.close();
                System.exit(0);

            default:
                System.out.println("Your enter the number is invalid, please check and enter again! ");
                break;
        }
        displayMenu();
        selection = input.nextInt();
    }

    public static void main(String[] args){
        mainMenu();
    }
}
