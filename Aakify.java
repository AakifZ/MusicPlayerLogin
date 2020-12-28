package project2;

import java.util.HashMap;
import java.util.Scanner;

public class Aakify {

	private static HashMap<String, Integer> Aakify = new HashMap<String, Integer>();

	public static void main(String[] args) {
		startUp();

	}

	public static boolean CheckIntegrity(String passwd) {
		int len = passwd.length();
		boolean uppercase = false;
		boolean lowercase = false;
		boolean symbols = false;
		boolean numbers = false;
		for (int i = 0; i < len; i++) {
			char temp = passwd.charAt(i);
			if (((temp >= 'a') && (temp <= 'z'))) {
				lowercase = true;

			} else if ((temp >= 'A') && (temp <= 'Z')) {
				uppercase = true;
			} else if (((temp >= '!') && (temp <= '/')) || ((temp >= ':') && (temp <= '@'))
					|| (temp >= ':') && (temp <= '@') || (temp <= '[') && (temp <= '_')
					|| (temp <= '{') && (temp <= '~')) {
				symbols = true;
			} else if ((temp >= '0') && (temp <= '9'));
			numbers = true;
		}
		return uppercase & lowercase;
	}

	public static void startUp() {
		System.out.println("Welcome to Aakify Music Entertainment System");
		System.out.println("   _______       __\r\n" + 
				" /   ------.   / ._`_\r\n" + 
				"|  /         ~--~    \\\r\n" + 
				"| |             __    `.____________________ _^-----^\r\n" + 
				"| |  I=|=======/--\\=========================| o o o |\r\n" + 
				"\\ |  I=|=======\\__/=========================|_o_o_o_|\r\n" + 
				" \\|                   /                       ~    ~\r\n" + 
				"   \\       .---.    .\r\n" + 
				"     -----'     ~~''");
		System.out.println("Do you want to signup (S), or login(L)?");
		Scanner input = new Scanner(System.in);
		String letterInput = input.nextLine().toUpperCase();
		while (!letterInput.equals("S") && !letterInput.equals("L")) {
			System.out.println("Enter 'S' or 'L' here: ");
			letterInput = input.next();

		}
		if (letterInput.equals("S")) {
			System.out.print("Enter Username: ");
			String username = input.nextLine();
			System.out.print("Enter Password: ");
			String password = input.nextLine();
			System.out.print("Confirm Password: ");
			String Cpassword = input.nextLine();
			signUp(username, password, Cpassword);

		} else if (letterInput.equals("L")) {
			System.out.print("Enter Username: ");
			String username = input.nextLine();
			System.out.print("Enter Password: ");
			String password = input.nextLine();
			signIn(username, password);

		}
		System.out.println("Would you like to go back to the start screen (Y for yes) (N for No)");
		String option = input.next().toUpperCase();
		while (!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")) {
			System.out.print("Enter Y or N: ");
			option = input.next();
			System.out.println(" ");
		}
		if (option.equalsIgnoreCase("Y")) {
			startUp();
		}
	}

	public static boolean signUp(String userName, String password, String confPassword) {
		if (Aakify.containsKey(userName)) {
			System.out.println("Username Taken");
			return false;
		} else if (!password.equals(confPassword)) {
			System.out.println("Invalid, Passwords do not match");
			return false;
		} else if (password.length() < 8 || !CheckIntegrity(password)) {
			System.out.println("Password does not meet our requirements of being strong");
			return false;
		}
		Aakify.put(userName, password.hashCode());
		System.out.println("Account Successfully Created");
		return true;
	}

	public static void signIn(String userName, String Password) {
		if (!Aakify.containsKey(userName)) {
			System.out.println("Username not found");
			return;
		} else if (!(Aakify.get(userName) == Password.hashCode())) {
			System.out.println("Incorrect Password");
			return;
		}
		System.out.println("Welcome");
	}
}
