package Mysql;

import java.util.Scanner;

public class MysqlExample2 {
	public static Scanner input = new Scanner(System.in);

	public static MysqlExample data = new MysqlExample("root", "localhost", "");

	public static void main(String[] args) {
		/*System.out.println("Welcome to Database");
		String selection = "1. Show Table\n" + "2. Add Personnel\n" + "3. Upadate Name\n" + "4. Update Surname\n"
				+ "5. Update Identity Number\n" + "6. Update Email\n" + "7. Delete Personnel\n" + "0. Exit";
		System.out.println(selection);
		selection();*/
		data.showLine(1);

	}

	public static void selection() {
		int selection = 1;
		while (selection > 0) {
			System.out.println("Selection : ");
			selection = input.nextInt();
			switch (selection) {
			case 1:
				showTable();
				break;
			case 2:
				addPersonnel();
				break;
			case 3:
				updateName();
				break;
			case 4:
				updateSurname();
				break;
			case 5:
				updadeIdentityNumber();
				break;
			case 6:
				updateEmail();
				break;
			case 7:
				deletePersonnel();
			case 0:
				System.out.println("Good Bye");
				break;
			default:
				System.out.println("You wrong entered. Please try again\n\n");
				break;
			}
		}

	}

	public static void showTable() {
		data.showTable();
	}

	public static void addPersonnel() {
		System.out.println("Name : ");
		String name = input.nextLine();
		input.nextLine();
		System.out.println("Surname : ");
		String surname = input.nextLine();
		System.out.println("Identity Number : ");
		long identityNumber = input.nextLong();
		input.nextLine();
		System.out.println("Email : ");
		String email = input.nextLine();
		
		System.out.println("Data saved successfully");
		data.addPersonnel(name, surname, identityNumber, email);
		
	}

	public static void updateName() {
		System.out.println("New Name : ");
		String name = input.nextLine();
		System.out.println("To be updated : ");
		int ID = input.nextInt();
		System.out.println("Data updated successfully");
		data.updateName(name, ID);
	}

	public static void updateSurname() {
		System.out.println("New Surname : ");
		String surname = input.nextLine();
		System.out.println("To be updated : ");
		int ID = input.nextInt();
		System.out.println("Data updated successfully");
		data.updateSurname(surname, ID);
	}

	public static void updadeIdentityNumber() {
		System.out.println("New Name : ");
		long identityNumber = input.nextLong();
		System.out.println("To be updated : ");
		int ID = input.nextInt();
		System.out.println("Data updated successfully");
		data.updateIdentityNumber(identityNumber, ID);
	}

	public static void updateEmail() {
		System.out.println("New Email : ");
		String email = input.nextLine();
		System.out.println("To be updated : ");
		int ID = input.nextInt();
		System.out.println("Data updated successfully");
		data.updateEmail(email, ID);
	}

	public static void deletePersonnel() {
		System.out.println("To be deleted ID : ");
		int ID = input.nextInt();
		System.out.println("Data deleted successfully");
		data.deletePersonnel(ID);
	}
}
