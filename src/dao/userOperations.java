package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import model.Users;

public class userOperations {
	static List<Users> usersList = new ArrayList<Users>();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	boolean log=false;
	public List<Users> addUsers(Users u) {
		if(usersList.add(u)) {
//			usersList.add(u);
			System.out.println("Sign Up Sucessful");
		}
		return usersList;
	}
	
	public void signUp() throws IOException {
		
		System.out.println("Enter your details :");
		System.out.print("Name :");
		String name = br.readLine();
		System.out.print("Enter Mobile No :");
		String mobileNo = br.readLine();
		System.out.print("Enter Email :");
		String email = br.readLine();
		System.out.print("Enter Password :");
		String password = br.readLine();
		System.out.print("Repeat Password :");
		String password2 = br.readLine();
		if(password.equals(password2)) {
		Users u= new Users(name, mobileNo, email, password);
//		userOperations uo = new userOperations();
		u.setName(name);
		u.setMobileNo(mobileNo);
		u.setEmail(email);
		u.setPassword(password);
		/*usersList=uo.*/addUsers(u);
		}
		else {
			System.out.println("Password doesnot match");
			signUp();
		}
		
	}
	
	public void displayUser() throws IOException {
		if(usersList.isEmpty()) {
			System.out.println("No user data was stored");
		}
		else {
//			System.out.println("Enter Mobile No ");
//			String input=br.readLine();
			System.out.println("Your details are");
			for (Users u: usersList) {
				
					
					System.out.print("\t"+u.getName());
					System.out.print("\t"+u.getMobileNo());
					System.out.print("\t"+u.getEmail());
					System.out.println("\t"+u.getPassword());
				
					
			}
		}
	}
	
	public boolean login() throws IOException {
		if(usersList.isEmpty()) {
			System.out.println("No user data found");
		}
		else {
		System.out.println("Enter details for login");
		System.out.print("Email : ");
		String email = br.readLine();
		System.out.print("Password : ");
		String password = br.readLine();
		for(Users u:usersList) {
			if((email.equals(u.getEmail())) && (password.equals(u.getPassword()))) {
			return true;
			}			
		  }	
		}
		return false;
	}
}
