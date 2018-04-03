/*
* Title: OnlineStore.java
* Abstract: Create a store that holds Product objects and places them in a Hash Map so that users can
* 			add, remove, and edit products. Hold Order objects in a Hash Table so that users can view
* 			lists of ordered products and see total cost.
* Author: Mark Mocek
* ID: 3279
* Date: 9/29/2017
*/

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class OnlineStore {
	
	//Create store name, hash map for Product, hash map for Order, and a variable for Scanner
	String name;
	HashMap<Integer, Product> productList = new HashMap<Integer, Product>();
	HashMap<Integer, Order> orderList = new HashMap<Integer, Order>();
	Scanner sc = new Scanner(System.in);
	
	//Constructor to give the store a name
	OnlineStore(String name) {
		this.name = name;
	}
	
	//Create a Product object and add it to the hash map
	public boolean addProduct() {
		
		//Product number, name, and price for a future Product object
		int productNum = 0;
		String name = "";
		double productPrice = 0.0;
		
		//Request product number and eat end of line
		System.out.print("Product Number: ");
		productNum = sc.nextInt();
		sc.nextLine();
		
		//Check hash map to see if product ID is already in use
		if(productList.get(productNum) != null) {
			System.out.println("Input Error: Product " + productNum + " already exists.");
			return false;
		}
		//Make sure desired ID is a four digit number
		if(productNum < 999 || productNum > 10000) {
			System.out.println("Input Error: Product key " + productNum + " must be a four digit code.");
			return false;
		}
		
		//Collect desired product name
		System.out.print("Product Name: ");
		name = sc.nextLine();
		
		//Collect product price and eat end of line
		System.out.print("Product Price: ");
		productPrice = sc.nextDouble();
		sc.nextLine();
		
		//Create new Product object
		Product n = new Product(name, productNum, productPrice);
		
		//Place object in hash map
		productList.put(productNum, n);
		
		//Check to make sure Product was added to hash map
		if(productList.get(productNum) != null) {
			System.out.println("Product Added - " + n);
			return true;
		}
		else {
			System.out.println("Product could not be successfully added.");
			return false;
		}
	}
	
	//Create new Order object
	public boolean makeOrder() {
		
		//Hold order number and set input to 1 so it can enter while loop
		int orderNum;
		int input = 1;
		
		//Collect desire order number and eat end of line
		System.out.print("Order Number: ");
		orderNum = sc.nextInt();
		sc.nextLine();
		
		//Check to see if order number is already taken
		if(orderList.get(orderNum) != null) {
			System.out.println("Error: Order " + orderNum + " already exists.");
			return false;
		}
		else {
			
			//Create new Order object
			Order o = new Order(orderNum);
			
			//Add Order object to hash map
			orderList.put(orderNum, o);
			
			//Add Product objects to Order object
			while(input != 0) {
				
				//Prompt user for either product number or exit code, eat end of line
				System.out.print("Type Product Number (0 to finish): ");
				input = sc.nextInt();
				sc.nextLine();
				
				//If input is exit code, display Products in list and exit
				if(input == 0) {
					o.orderInfo();
					return true;
				}
				//If zero is not entered, try to add Product to the list
				else {
					
					//Check if the Product exists
					if(productList.get(input) == null) {
						System.out.println("Error: Product Number " + input + " does not exist.");
					}
					//If Product exists create a new Product object and send it to Order
					else {
						Product n = new Product(productList.get(input));
						o.addProduct(n);	
					}
				}
			}
			
			return false;
		}
	}
	
	//Display Product information
	public void productInfo() {
		
		//Hold input from user and product number
		String input = "";
		int productNum = 0;
		
		//Collect user input
		System.out.print("Product number (Just enter for all products): ");
		input = sc.nextLine();
		
		//Check if user put an input in or if it is empty
		if(input.isEmpty()) {
			
			//Iterator for list generation
			int ii = 1;
			
			//Go through hash map and display all Products
			for (Map.Entry list : productList.entrySet()) {
				
				//Create Product object to hold hash map object information for display
				Product n = new Product(list.getValue());
				
				//Display information
				System.out.println(ii + ". " + n.getName() + " (No. " + n.getNumber() + "): $" + n.getPrice());
				
				//Iterate for next item
				ii++;
		    }
			
		}
		//If the input is not empty
		else {
			
			//Convert the String collected into an Integer
			productNum = Integer.valueOf(input);
			
			//Attach Product to variable for later use
			Product n = productList.get(productNum);
			
			//Check to see if the object is null, if it is exit
			if(n == null) {
				System.out.println("Input Error: Product " + productNum + " doesn't exist.");
				return;
			}
			
			//Display Product information
			System.out.println("No. " + productNum + ": " + n.getName() + ", $" + n.getPrice());
		}
	}
	
	//Change an existing Product
	public boolean updateProduct() {
		
		//Hold input from user and information for Product
		String input = "";
		String name = "";
		int productNum = 0;
		double productPrice = 0.0;
		
		//Prompt user for desired Product to update
		System.out.print("Product Number To Update: ");
		productNum = sc.nextInt();
		sc.nextLine();
		
		//Connect Product to variable
		Product n = productList.get(productNum);
		
		//Check to see if there was a Product in the hash map
		if(n == null) {
			System.out.println("Input Error: Product " + productNum + " doesn't exist.");
			return false;
		}
		//If there was a Product, check what should be changed
		else {
			
			//Prompt user for new name for Product
			System.out.println("If you do not want to change data, press the Enter key.");
			System.out.print("Product Name (" + n.getName() + "): ");
			name = sc.nextLine();
			
			//Set name to current if user doesn't give a new name
			if(name.isEmpty()) {
				name = n.getName();
			}
			
			//Prompt user for new price for Product
			System.out.print("Product Price (" + n.getPrice() + "): ");
			input = sc.nextLine();
			
			//Set price to current if there is no new price
			if(input.isEmpty()) {
				productPrice = n.getPrice();
			}
			//If the user did set a new price, cast it to double from String
			else {
				productPrice = Double.valueOf(input);
			}
			
			//Set new name and price
			n.setName(name);
			n.setPrice(productPrice);
			
			//Display updated information
			System.out.println("Product Updated - " + n);
			return true;
		}		
	}
	
	//Delete an existing Product from the hash map
	public boolean deleteProduct() {
		
		//Hold Product's number
		int productNum = 0;
		
		//Prompt user for Product's number
		System.out.print("Product Number: ");
		productNum = sc.nextInt();
		sc.nextLine();
		
		//Check to see if Product is in the hash map
		if(productList.get(productNum) != null) {
			
			//Remove indicated Product from the hash map
			productList.remove(productNum);
			
			//Announce success
			System.out.println("Product " + productNum + " deleted.");
			return true;
		}
		//If the Product does not exist in the hash map
		else {
			System.out.println("Input Error: Product " + productNum + " doesn't exist.");
			return false;
		}
	}
}