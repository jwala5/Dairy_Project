package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.Products;
import model.Orders;

public class Operations {
	static List<Products> list = new ArrayList<Products>();
	orderOperations oo =new orderOperations();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// method for adding products to list
	public void addProduct(Products products) {
		list.add(products);

	}
	
	public void addList() throws IOException {
		
		System.out.println("Enter below details :");
		System.out.print("Enter Id :");
		int id=Integer.parseInt(br.readLine());
		System.out.print("Enter Name :");
		String name=br.readLine();
		System.out.print("Enter Price :");
		float price=Float.parseFloat(br.readLine());
		System.out.print("Enter Quantity :");
		String quantity=br.readLine();
		Products products = new Products(id,name,price,quantity);
//		Operations op = new Operations();
		products.setId(id);
		products.setName(name);
		products.setPrice(price);
		products.setQuantity(quantity);
		/*list=*/addProduct(products);
		
	}
	
	// method for removing products from list
public void removeList() throws IOException {
		try {
		if(list.isEmpty()) {
			System.out.println("\n   ***** No items to delete *****\n");
		}
		else {
			System.out.print("Enter Id to delete:");
			int id = Integer.parseInt(br.readLine());
			for (Products p: list) {
				if(p.getId() == id) {
					System.out.println(p.getName()+" was deleted Sucessfully");
					list.remove(p);
					
				}
			}
		}
		}
		catch (Exception e) {
			System.out.println();
		}
}

// method to display the products
public void displayList() {
	
	if(list.isEmpty()) {
		System.out.println("\n   ***** No items to display *****\n");
	}
	else {
		System.out.println("\t\tId"+"\t\tName"+"\t\tPrice");
		for(Products p :list) {
			System.out.print("\t\t"+p.getId());
			System.out.print("\t\t"+p.getName());
			System.out.println("\t\t"+p.getPrice()+" for "+p.getQuantity());
		}
		
	}
				
}

// sorting

public void sortByNameAsc() {
	if(list.isEmpty()) {
		System.out.println("\n   ***** No items to sort - Please add the items first *****\n");
	}
	else {
//		list.sort(Comparator comparing(Products::getName()));
		Collections.sort(list,new Comparator<Products>() {

			@Override
			public int compare(Products o1, Products o2) {
				return o1.getName().compareTo(o2.getName());
			}
			
		});
		displayList();
	}
}

public void sortByPriceAsc() {
	if(list.isEmpty()) {
		System.out.println("\n   ***** No items to sort - Please add the items first *****\n");
	}
	else {
//		list.sort(Comparator comparing(Products::getPrice()));
		Collections.sort(list,new Comparator<Products>() {

			@Override
			public int compare(Products o1, Products o2) {
				return Float.compare(o1.getPrice(), o2.getPrice());
			}
			
		});
		displayList();
	}
}

public void sortByPriceDesc() {
	if(list.isEmpty()) {
		System.out.println("\n   ***** No items to sort - Please add the items first *****\n");
	}
	else {
//		list.sort(Comparator comparing(Products::getPrice()));
		Collections.sort(list,new Comparator<Products>() {

			@Override
			public int compare(Products o1, Products o2) {
				return Float.compare(o2.getPrice(), o1.getPrice());
			}
			
		});
		displayList();
	}
}

public void sortByNameDesc() {
	if(list.isEmpty()) {
		System.out.println("\n   ***** No items to sort - Please add the items first *****\n");
	}
	else {
//		list.sort(Comparator comparing(Products::getName()));
		Collections.sort(list,new Comparator<Products>() {

			@Override
			public int compare(Products o1, Products o2) {
				return o2.getName().compareTo(o1.getName());
			}
			
		});
		displayList();
	}
}

public void updateList() throws IOException {
	if(list.isEmpty()) {
		System.out.println("\n   ***** No items - Please add the items first *****\n");
	}
	else {
		System.out.print("Enter Id : ");
		int id=Integer.parseInt(br.readLine());
		for(Products p : list) {
			if(id == p.getId()) {
				System.out.print("Enter name : ");
				String name = br.readLine();
				System.out.println("Enter Price : ");
				float price = Float.parseFloat(br.readLine());
				System.out.print("Enter Quantity :");
				String quantity=br.readLine();
				p.setName(name);
				p.setPrice(price);
				p.setQuantity(quantity);
				System.out.println("Update sucess");
			}
		}
	}
}

public int size() {
	return list.size();
}

public void order() throws IOException{
	System.out.println("\t\t Products in availability\n");
	displayList();
	System.out.print("How many products Do You Want :");
	byte n=Byte.parseByte(br.readLine());
	if(n>size() || n<0) {
		System.out.println("out of range");
		order();
	}
	else
	{
	String selection[]= new String[n];
	for(byte i=0;i<n;i++) {
		System.out.print("Enter name of the product - "+(i+1)+": ");
		selection[i]=br.readLine();
	}
	for (byte i=0;i<n;i++) {
		for(Products p: list) {
			if(selection[i].equals(p.getName())){
				System.out.print("How much quantity do u need of "+p.getName());
				byte quantity = Byte.parseByte(br.readLine());
//				int id=p.getId();
//				String name = p.getName();
				float price = p.getPrice();
				float total = price*quantity;
				Orders o = new Orders(p.getId(),p.getName(),p.getPrice(),quantity,total);
				o.setId(p.getId());
				o.setName(p.getName());
				o.setPrice(p.getPrice());
				o.setQuantity(quantity);
				o.setTotal(total);
				oo.addOrders(o);
			}
		}
	}
	
	}
}
}
