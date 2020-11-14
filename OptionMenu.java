package Project;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class OptionMenu extends Account {
	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

	public void getLogin() throws IOException {
		int x = 1;
		do {
			try {
				data.put(9876543, 1234);
				data.put(8989898, 1890);
				data.put(8239898, 2890);
				System.out.println("Welcome to Edureka ATM.\n");

				System.out.println("Enter your Customer number: \n");
				setCustomerNumber(menuInput.nextInt());

				System.out.println("Enter your secret pin: \n");
				setPinNumber(menuInput.nextInt());
			} catch (Exception e) {
				System.out.println("\n" + "Invalid character(s). Only numbers" + "\n");
				x = 2;
			}
			for (Entry<Integer, Integer> entry : data.entrySet()) {
				if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
					getAccountType();
				}
			}
			System.out.println("\n" + "Invalid Customer number or pin");
		} while (x == 1);
	}

	public void getAccountType() {
		System.out.println("Select the account you want to access: ");
		System.out.println("Type 1 - Checking Account");
		System.out.println("Type - 2 - Savings Account");
		System.out.println("Type - 3 Exit");
		System.out.println("Choice: ");
		int selection = menuInput.nextInt();
		switch (selection) {
		case 1:
			getChecking();
			break;

		case 2:
			getSaving();
			break;

		case 3:
			System.out.println("Thank you for using this ATM.");
			break;

		default:
			System.out.println("\n" + "Invalid Choice" + "\n");
			getAccountType();
		}
	}

	public void getChecking() {
		System.out.println("Checking Account: ");
		System.out.println("Type 1 -  View Balance");
		System.out.println("Type 2 - Withdraw funds");
		System.out.println("Type 3 - Desposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.println("Choice: ");

		int selection = menuInput.nextInt();
		switch (selection) {
		case 1:
			System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
			getAccountType();
			break;
		case 2:
			getCheckingWithdrawInput();
			getAccountType();
			break;
		case 3:
			getCheckingDepositInput();
			getAccountType();
			break;
		case 4:
			System.out.println("Thank you for using this ATM, bye");
			break;
		default:
			System.out.println("\n" + "Invalid Choice" + "\n");
			getChecking();
		}
//		return selection;
	}

	public void getSaving() {
		System.out.println("Saving Account: ");
		System.out.println("Type 1 -  View Balance");
		System.out.println("Type 2 - Withdraw funds");
		System.out.println("Type 3 - Desposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.println("Choice: ");

		int selection = menuInput.nextInt();
		switch (selection) {
		case 1:
			System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
			getAccountType();
			break;
		case 2:
//			getCheckingWithdrawInput(); 
			getSavingWithdrawInput();
			getAccountType();
			break;
		case 3:
//			getCheckingDepositInput(); 
			getSavingDepositInput();
			getAccountType();
			break;
		case 4:
			System.out.println("Thank you for using this ATM, bye");
			break;
		default:
			System.out.println("\n" + "Invalid Choice" + "\n");
			getChecking();
		}
	}
	int selection;
}