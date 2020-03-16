package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import businessLogic.*;
import dao.Operations;
import dao.orderOperations;
import dao.userOperations;
//import dao.*;
import model.*;



public class Main {
	// variables for products
//			static int id;
//			static String name;
//			static float price;
	static List<Products> list = new ArrayList<Products>();
//	static List<Admins> adminsList = new ArrayList<Admins>();
	static List<Users> usersList = new ArrayList<Users>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		Operations op = new Operations();
		userOperations uo = new userOperations();
		orderOperations oo= new orderOperations();
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		byte menu ;
		do{
			
		System.out.println("<<<   Welcome to Daily-Dairy  >>>");
		System.out.println("\t 1. Admin");
		System.out.println("\t 2. User");
		System.out.println("\t 3. Exit");
		System.out.print("\t Your Choice :");
		menu = Byte.parseByte(br.readLine());
		switch (menu){
		case 1: System.out.print("Enter you email: ");
				String email1=br.readLine();
				System.out.print("Enter you password: ");
				String password1=br.readLine();
				Validation v=new Validation();
				boolean result = v.validate(email1, password1);
				if(result) {
					byte options = 0;
					do {
						System.out.println("\t Admin Menu ");
						System.out.println("-------------------------------");
						System.out.println("\t 1. Add Products");
						System.out.println("\t 2. View Products");
						System.out.println("\t 3. Remove Products");
						System.out.println("\t 4. Update Products");
						System.out.println("\t 5. View Orders");
						System.out.println("\t 6. Generate Reports");
						System.out.println("\t 7. Exit");
						System.out.print("\t Your Choice :");
						try {
						options = Byte.parseByte(br.readLine());
						switch(options) {
						case 1:
							System.out.print("How many items do you want to add : ");
							byte n = Byte.parseByte(br.readLine());
							while(n>0) {
								op.addList();
								n--;
							}
							System.out.println("Items added secesfully\n");
							break;
							
						case 2: op.displayList(); break;
						case 3: op.removeList();break;
						case 4: op.updateList();break;
						case 5: oo.displayOrders();break;
						case 6: oo.genereateReports();break;
						case 7: System.out.println("\n\t \\...Thank U.../\n"); break;
						default:System.out.println("\n\tWrong entry...\n");
							
						}
						}
						catch(Exception e){
							System.out.println("\n\tEnter any number(only)\n");
						}
					}while(options != 7);	
				}
				
				break;
				//main menu case 1 end
		case 2:
			byte option;boolean login = false;
			do {
			System.out.println("<<<   Select type   >>>");
			System.out.println("\t 1. View Products");
			System.out.println("\t 2. Login");
			System.out.println("\t 3. Sign Up");
			System.out.println("\t 4. Sort Products");
			System.out.println("\t 5. Log Out");
			System.out.println("\t 6. Place Order");
			System.out.println("\t 7. Exit");
			System.out.print("\t Your Choice :");
			option = Byte.parseByte(br.readLine());
			
			switch(option) {
			case 1: op.displayList(); break;
			case 2:
				if(login == true) {
					System.out.println("\n\t\tAlready logged in - Log Out First\n");
				}
				else {
				boolean x = uo.login();
				if(x == true)
				{
					System.out.println("Login sucess");
					login = true;
				}
					
				else 
					System.out.println("Login failed");
				}
				break;
			case 3: uo.signUp(); break;
			case 4: 
				System.out.println("\nSort by Name - Ascending Order\n");
				op.sortByNameAsc();
				System.out.println("\nSort by Name - Descending Order\n");
				op.sortByNameDesc();
				System.out.println("\nSort by Price - Ascending Order\n");
				op.sortByPriceAsc();
				System.out.println("\nSort by Price - Descending Order\n");
				op.sortByPriceDesc();
				
				
			
				
				
				
				break; // User menu case-4 ends
			case 5: login = false; break;
			case 6: 
				if(login == false) {
					System.out.println("please do login first");
				}
				else
				op.order();
				break;
			case 7: System.out.println("\t \\...Thank U.../"); break;
			default:System.out.println("\tWrong entry...");
			
			}
			
			}while(option !=7);
			
		
				break;
				//main menu case 2 end
		case 3:
			System.out.println("\t \\...Thank U.../");
				break;
		default: System.out.println("\tWrong entry...");
		}
		
		}while(menu != 3);
		System.out.println("Mission completed");
		
	}
//	public static void UserOperation() throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("Enter below details :");
//		System.out.print("Enter Id :");
//		int id=Integer.parseInt(br.readLine());
//		System.out.print("Enter Name :");
//		String name=br.readLine();
//		System.out.print("Enter Price :");
//		float price=Float.parseFloat(br.readLine());
//		Products products = new Products(id,name,price);
//		Operations op = new Operations();
//		products.setId(id);
//		products.setName(name);
//		products.setPrice(price);
//		/*list=*/op.addProduct(products);
//		
//	}
//	public static void displayList() {
//		
//		if(list.isEmpty()) {
//			System.out.println("\n   ***** No items to display *****\n");
//		}
//		else {
//			System.out.println("\t\tId"+"\t\tName"+"\t\tPrice");
//			for(Products p :list) {
//				System.out.print("\t\t"+p.getId());
//				System.out.print("\t\t"+p.getName());
//				System.out.println("\t\t"+p.getPrice());
//			}
//		}
//					
//	}
	
//public static void removeList() throws IOException {
//		
//		if(list.isEmpty()) {
//			System.out.println("\n   ***** No items to delete *****\n");
//		}
//		else {
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			System.out.println("Enter id to delete");
//			int id= Integer.parseInt(br.readLine());
//			for(Products p :list) {
//				if(id == p.getId()) {
//					list.remove(p);
//				}
//			}
//		}
//}
	
//	public static void signUp() throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("Enter your details :");
//		System.out.print("Name :");
//		String name = br.readLine();
//		System.out.print("Enter Mobile No :");
//		String mobileNo = br.readLine();
//		System.out.print("Enter Email :");
//		String email = br.readLine();
//		System.out.print("Enter Password :");
//		String password = br.readLine();
//		Users u= new Users(name, mobileNo, email, password);
//		u.setName(name);
//		u.setMobileNo(mobileNo);
//		u.setEmail(email);
//		u.setPassword(password);
//		userOperations uo = new userOperations();
//		usersList=uo.addUsers(u);
//		
//	}
//	public static void login() throws IOException {
//		System.out.println("Enter details for login");
//		System.out.println("Email : ");
////		String email = br.readLine();
////		String password = br.readLine();
//		for(Users u:usersList) {
//			System.out.println(u.getEmail());
//			System.out.println(u.getPassword());
//		}
//	}

}
