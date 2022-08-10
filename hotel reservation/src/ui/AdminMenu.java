package ui;

import api.AdminResource;
import model.RoomType;

import java.nio.file.LinkPermission;
import java.util.Scanner;

public class AdminMenu {

    private static AdminResource adminResource;

    public static void displayMenu(){
        System.out.println("Welcome Hotel Reservation System, This is Admin Menu");
        System.out.println("----------------------------------------------------");
        System.out.println("1. See Customers List");
        System.out.println("2. See Room List ");
        System.out.println("3. See Reservations");
        System.out.println("4. Add a Room");
        System.out.println("5. Back to main menu");
    }

    public static void addHotelRoom(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Room Number you want to add: ");
        String roomId = scanner.next();
        System.out.println("Enter the Room Type Single/Double you add: ");
        RoomType roomType = RoomType.valueOf(scanner.next());
        System.out.println("Enter the Room Price per Night");
        Double roomPrice = scanner.nextDouble();

        AdminResource.addRoom(roomId, roomPrice, roomType);
    }

    public static void startAdmin(){
        Scanner input = new Scanner(System.in);
        int selection = 0;

        switch (selection){
            case 1:
                System.out.println("Your selection is requested all customers");
                System.out.println(adminResource.getAllCustomers());
                break;

            case 2:
                System.out.println("Your selection is requested all rooms");
                System.out.println(adminResource.getAllRooms());
                break;

            case 3:
                System.out.println("Your selection is requested all reservations");
                adminResource.displayAllReservations();

            case 4:
                System.out.println("Your selection is requested to add a room into hotel system");
                addHotelRoom();

            case 5:
                MainMenu.mainMenu();
                return;
        }

        displayMenu();;
        selection = input.nextInt();
    }
}
