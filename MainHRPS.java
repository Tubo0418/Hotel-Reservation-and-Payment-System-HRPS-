package HRPS;

import java.util.ArrayList;
import java.util.Scanner;

public class MainHRPS {

	public static void main(String[] args) {
		
		int selection = 0;

		do {
			System.out.println("============================================================");
			System.out.println("Please enter selection from the following: ");
			
			System.out.println("1: Create Guest");
			System.out.println("2: Search Guest");
			System.out.println("3: Update Guest");
			
			System.out.println("4: Create Reservation");
			System.out.println("5: Update Reservation");
			System.out.println("6: Remove Reservation");
			System.out.println("7: Print Reservation");
			
			System.out.println("8: Create Room Details");
			System.out.println("9: Update Room Details");
			
			System.out.println("10: Enter Room Service Orders");
			System.out.println("11: Create Room Service Menu Item");
			System.out.println("12: Update Room Service Menu Item");
			System.out.println("13: Remove Room Service Menu Item");
			
			System.out.println("14: Check Room Availability");
			System.out.println("15: Check-In");
			System.out.println("16: Check-out and Print Bill Invoice");
			System.out.println("17: Print Room Status Report");
			
			System.out.println("99: Quit");
			System.out.println("============================================================");
			
			
			Scanner sc = new Scanner(System.in);
			selection = sc.nextInt();
			
			switch (selection) {
			case 1: // create guest
				break;
			case 2: // search guest by id and name
				break;
			case 3: // update guest details
				break;
				
			case 4: // create reservation & guest
				guestID++;
				gList.createGuest();
				do {
					System.out.println("Enter your desired room type (Single/Double/Deluxe/VIP)");
					target_roomType = sc.nextLine();
					System.out.println("Enter your desired room number");
					target_roomNumber = sc.nextLine();
				} while (!roomManager.checkRoomType(target_roomType, target_roomNumber));
				roomManager.assign(guestID, "Reserved", target_roomNumber, target_roomType);
				reservation[rCode] = new Reservation(rCode, guestID, target_roomNumber, target_roomType);
				rCode++;
				break;
			case 5:	// update reservation
				System.out.println("Enter your reservation code");
				target_rCode = sc.nextInt();
				sc.nextLine();
				if (target_rCode > rCode - 1)
					System.out.println("No such reservation!");
				else {
					sub_choice = reservation[target_rCode].checkReservationStatus();
					if (sub_choice != 1) {
						do {
							System.out.println("Which details of reservation you would like to change?");
							System.out.println("1. About guest details");
							System.out.println("2. About check in date and time");
							System.out.println("3. Quit");
							sub_choice = sc.nextInt();
							sc.nextLine();
							switch (sub_choice) {
							case 1:
								if (gList.getCount() > 0) {
									System.out.println("Enter the name of guest to be updated:");
									String search = sc.nextLine();
									Guest Search = gList.searchGuest(gList, search);
									if (Search.getEmpty())
										System.out.println("Guest does not exist in the database.");
									else {
										gList.searchGuest(gList, search).updateGuest();
									}
								} else
									System.out.println("No guest resides in this hotel. Create a new guest to update.");
								break;
							case 2:
								reservation[target_rCode].updateReservation();
								break;
							case 3:
								break;
							default:
								System.out.println("Wrong input!");
							}
						} while (sub_choice != 3);
					} else
						System.out.println("You have been checked in already!");
				}
				break;
			case 6: // remove reservation
				
				break;
			case 7:	// print reservation
				printDetails(rsv);
				break;
				
			case 8: // create room (?)
				break;
			case 9:	// update room details (status)
				break;
				
			case 10: // enter room service orders
				break;
			case 11: // create menu item
				break;
			case 12: // update menu item 
				break;
			case 13: // remove menu item
				break;
				
			case 14: // check room availability
				break;
			case 15: // check in
				break;
			case 16: // check out & print bill invoice
				break;
			case 17: // print room status report by TYPE (single, double) 
					 // or by STATUS (vacant, occupied)
				break;
				
			case 99: // QUIT
				break;
				
			default: 
				System.out.println("Error. Please retry.");
				break;
			}	
		}
		while (selection != 99);

	}
	
	// this is where we write our methods for the MAIN class

}

