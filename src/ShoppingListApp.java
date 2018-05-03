
//Programed by Jiao XU  5/3/2018
//shopping list app

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ShoppingListApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		HashMap<String, Double> products = new HashMap<>();// Adding items with name and price

		products.put("babyback ribs", 54.99);
		products.put("chicken wings", 47.99);
		products.put("chicken tenders", 33.99);
		products.put("turkey legs", 35.99);
		products.put("banana", 0.99);
		products.put("apple", 3.99);
		products.put("honeydew", 3.49);
		products.put("pork chop", 68.99);
		products.put("whole turkey", 58.99);
		products.put("beef brisket", 71.99);

		ArrayList<String> orderList = new ArrayList<>();
		ArrayList<Double> priceList = new ArrayList<>();

		String cont = "yes";
		while (cont.equalsIgnoreCase("yes")) {
			// display menu
			display(products);

			// prompt user to enter on item name
			System.out.println("What item would you like to order?");

			// get user order
			String userOrder = scan.nextLine().toLowerCase();
			// validate the input
			if (products.containsKey(userOrder)) {
				// display the ordered item
				System.out.print("Adding " + userOrder + " to cart at $" + products.get(userOrder));

			} else {
				System.out.println("the item you entered does not exist, try again");
				continue;
			}

			// add to order if no error

			orderList.add(userOrder);

			priceList.add(products.get(userOrder));

			// .args.priceList.get(userOrder.indexOf(userOrder)));
			// System.out.println(priceList);

			// prompt user to continue with order
			System.out.println("\nWould you like to continue:(yes / no)");
			cont = scan.nextLine();

		}

		// display user order items and prices in columns(math)

		System.out.println("Thanks for your order!\nHere's what you got:\n");
		// display the header in a format.
		System.out.printf("%-25s %10s", "Item", "Price");

		// display the dividing line
		System.out.printf("\n==========================================\n");
		String format = "%-30s $%.2f%n";
		for (int i = 0; i < orderList.size(); i++) {
			System.out.printf(format, orderList.get(i), priceList.get(i));

		}

		// display the average price of items ordered
		Double avgPrice = averagePrice(priceList);
		System.out.print("Average price per item in order is: $ ");
		System.out.printf("%.2f", avgPrice);

		// item with highest cost
		String hItem = orderList.get(highestIndex(priceList));
		System.out.println("\nThe item with the highest cost is " + hItem);

		// item with lowest cost
		String lItem = orderList.get(lowestIndex(priceList));
		System.out.println("The item with the lowest cost is " + lItem);

		scan.close();
	}

	private static Double averagePrice(ArrayList<Double> priceList) {
		Double avg = null;
		Double sum = 0.0;
		// calculate the average of the price
		for (int i = 0; i < priceList.size(); i++) {
			sum = sum + priceList.get(i);

		}
		avg = sum / priceList.size();
		return avg;
	}

	private static int highestIndex(ArrayList<Double> priceList) {
		int highestIndex = 0;
		double highestPrice = 0.0;
		// find out the highest price product index
		for (int i = 0; i < priceList.size(); i++) {

			if (highestPrice < priceList.get(i))
				highestPrice = priceList.get(i);
		}
		highestIndex = priceList.indexOf(highestPrice);
		return highestIndex;
	}

	private static int lowestIndex(ArrayList<Double> priceList) {
		int lowestIndex = 0;
		double lowestPrice = 100.0;
		for (int i = 0; i < priceList.size(); i++) {
			if (lowestPrice > priceList.get(i))
				lowestPrice = priceList.get(i);
		}
		lowestIndex = priceList.indexOf(lowestPrice);
		return lowestIndex;
	}

	public static void display(HashMap<String, Double> products) {
		String format = "%-30s $%.2f%n";
		// display the header in a format.
		System.out.printf("%-25s %10s", "Item", "Price");

		// display the dividing line
		System.out.printf("\n==========================================\n");

		for (String product : products.keySet()) {
			System.out.printf(format, product, products.get(product));

		}
	}
}
