import java.util.Scanner;

public class OnlineStoreDemo {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		OnlineStore csumbOnlineStore = new OnlineStore("CSUMB");
		int option;
		
		System.out.println("Welcome to CSUMB OnlineStore");
		
		do {
			System.out.println("Select your choice:");
			System.out.println("	1. Add Product");
			System.out.println("	2. Delete Product");
			System.out.println("	3. Product Info");
			System.out.println("	4. Make Order");
			System.out.println("	5. Update Product");
			System.out.println("	6. Exit");
			option = sc.nextInt();
			
			if(option == 1) {
				csumbOnlineStore.addProduct();
			}
			if(option == 2) {
				csumbOnlineStore.deleteProduct();
			}
			if(option == 3) {
				csumbOnlineStore.productInfo();
			}
			if(option == 4) {
				csumbOnlineStore.makeOrder();
			}
			if(option == 5) {
				csumbOnlineStore.updateProduct();
			}
			if(option == 6) {
				System.out.println("Bye");
				return;
			}
			else {
				System.out.println("Incorrect option");
			}
			System.out.println("\n");
		} while(true);
	}
}