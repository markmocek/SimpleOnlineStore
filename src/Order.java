/*
* Title: Order.java
* Abstract: Create an object to hold a list of Products and their total price.
* Author: Mark Mocek
* ID: 3279
* Date: 9/29/2017
*/

import java.util.ArrayList;

public class Order {
	
	//Hold Order number, total price of all Products, and a list of Products
	int orderNum;
	double totalPrice;
	ArrayList<Product> products = new ArrayList<Product>();
	
	//Constructor
	Order(int orderNum) {
		this.orderNum = orderNum;
		this.totalPrice = 0.0;
	}
	
	//Display information for ordered Products
	public void orderInfo() {
		
		//Go through each item in the ArrayList
		for(int ii = 0; ii < products.size(); ii++) {
			
			//Hold current Product in a variable for later use
			Product current = products.get(ii);
			
			//Display the information of the current Product
			System.out.println("Item " + (ii + 1) + ": " + current.getName() + " (No. " + current.getNumber() + "): $" + current.getPrice());
		}
		
		//Display the total price for all Products in the list
		System.out.println("Total Price: $" + this.totalPrice);
	}
	
	//Add a Product object to the ArrayList
	public boolean addProduct(Object other) {
		
		//Check to make sure passed object is a Product object
		if(other instanceof Product) {
			
			//Attach passes object to variable
			Product another = (Product) other;
			
			//Add object to the ArrayList
			products.add(another);
			
			//Add the price of the Product to the total price
			this.totalPrice = this.totalPrice + another.getPrice();
			
			return true;
		}
		
		return false;
	}
	
	//toString to display all information
	public String toString() {
		
		//Hold String of all products
		String allProducts = "";
		
		//Go through each item in the ArrayList
		for(int ii = 0; ii < products.size(); ii++) {
					
			//Hold current Product in a variable for later use
			Product current = products.get(ii);
					
			//Display the information of the current Product
			allProducts = "Item " + (ii + 1) + ": " + current.getName() + " (No. " + current.getNumber() + "): $" + current.getPrice() + "\n";
		}
		
		return(allProducts + "Total Price: " + this.totalPrice);
	}
}