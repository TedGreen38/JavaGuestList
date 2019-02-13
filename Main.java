/*
 * Author: Ted Green
 * Date: Jan 22, 2019
 * Program: List Program
 * this program will create a guest list from user inputed data and then save that data to a text file.
 */

//Imported Libraries needed for program
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		//initialize scanner input
		Scanner input = new Scanner (System.in);
		
		//key variables
		boolean finished = false;
		
		//intro message
		System.out.println("Hello there, this program is designed to create a text file containing a guest list.");
		
		File file = new File("guestList.txt");
		
		//Create the file
		if (file.createNewFile())
		{
		    System.out.println("File 'guestList.txt' has been created!");
		} else {
		    System.out.println("File 'guestList.txt' already exists. Appending to file.");
		}
		
		while (finished == false) {
			//gets user input for a new guest. including their name, age, and status (regular, VIP)
			System.out.println("Please enter in the guest's name, age, and status.");
			input.nextLine();
			System.out.print("Name:");
			String name = input.nextLine();
			System.out.print("Age:");
			String age = input.nextLine();
			System.out.print("Status:");
			String status = input.nextLine();
			
			//inserts data into the guest class.
			Guest guest = new Guest(name,age,status);
			System.out.println("The guest you have entered is "+guest.getName()+", age "+guest.getAge()+", and currently has "+guest.getStatus()+" status");
			
			//write guest info to file, appending its contents with existing guests.
			writeToFile(guest.getName(),guest.getAge(),guest.getStatus(), file);
			
			//asks user if they would like to run the program again.
			System.out.print("Would you like to run the program again? (y for yes | n for no): ");
			char c = input.next().charAt(0);
			
			//if else statement that determines if the program will run again.
			if (c == 'y' || c == 'Y') {
				System.out.println("Restarting Program.");
			} else if (c == 'n' || c == 'N') {
				finished = true;
			} else {
				System.out.println("ERROR: Invalid Response: Restarting Program.");
			}
			//System.out.println();
		}
		//ending statement
		System.out.println("This concludes the program. Have a great day!");
	}

	public static void writeToFile(String name, String age, String status, File file) throws IOException{
		
		String str = (name+" | age: "+age+" | Status: "+status);
		BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
	    writer.append(str+"\n");
	     
	    writer.close();
	}
}
