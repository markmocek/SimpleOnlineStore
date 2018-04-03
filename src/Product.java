/*
* Title: Product.java
* Abstract: Create an object to hold a Product's name, number, and price for use in the OnlineStore
* 			and Order classes.
* Author: Mark Mocek
* ID: 3279
* Date: 9/29/2017
*/

public class Product {
	
	//Product's name, number, and price
	String name;
	int productNum;
	double unitPrice;
	
	//Default constructor
	Product(String name, int productNum, double unitPrice) {
		this.name = name;
		this.productNum = productNum;
		this.unitPrice = unitPrice;
	}
	
	//Construct for object argument
	Product(Object other) {
		
		//If passed argument is a Product object
		if(other instanceof Product) {
			Product another = (Product) other;
			
			this.name = another.name;
			this.productNum = another.productNum;
			this.unitPrice = another.unitPrice;
		}
	}
	
	//Send Product name
	public String getName() {
		return name;
	}
	
	//Send Product number
	public int getNumber() {
		return productNum;
	}
	
	//Send Product price
	public double getPrice() {
		return unitPrice;
	}
	
	//Change Product name
	public boolean setName(String name) {
		this.name = name;
		return true;
	}
	
	//Change Product price
	public boolean setPrice(double price) {
		this.unitPrice = price;
		return true;
	}
	
	//toString for easy display of information
	public String toString() {
		return (name + ", No: " + productNum + ", Price: " + unitPrice);
	}
	
	//Check to see if two Products are the same
	public boolean equals(Object other) {
		if(other instanceof Product) {
			Product another = (Product) other;
			
			return (this.name == another.name &&
					this.productNum == another.productNum &&
					this.unitPrice == another.unitPrice);
		}
		
		return false;
	}
	
}