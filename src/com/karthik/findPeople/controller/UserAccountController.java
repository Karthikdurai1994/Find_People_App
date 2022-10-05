package com.karthik.findPeople.controller;

import com.karthik.findPeople.dao.UserAccountDAO;
import com.karthik.findPeople.dao.UserAccountDAOImpl;
import com.karthik.findPeople.model.Interest;
import com.karthik.findPeople.model.UserAccount;
import java.util.Scanner;

public class UserAccountController {
 
   // "register" method for saving UserAccount object
   public void register(UserAccountDAO user) {
	   UserAccount obj1 = new UserAccount(); // useraccount object created
	   // saving all the details in obj1
	   obj1.setId(1);
	   obj1.setUserName("John");
	   obj1.setPassword("sdf456sdw#dr");
	   obj1.setAge(34);
	   obj1.setEmail("john@example.com");
	   obj1.setPhoneNumber("4576234567");
	   obj1.setGender("Male");
	   obj1.setCity("Mumbai");
	   obj1.setCountry("India");
	   Interest interestObj1 = new Interest(); // Interest obj is created and saved in UserAccount object [obj1]
	   interestObj1.setId(1);
	   interestObj1.setLikes("Reading Books");
	   interestObj1.setDislikes("Laziness");
	   interestObj1.setHobbies("Playing cricket");
	   interestObj1.setProfileURL("https://findPeople/profile-john");
	   interestObj1.setAbout("Optimistic Person");
	   obj1.setInterest(interestObj1);
	   user.save(obj1); // saving the UserAccount object [obj1] in the hashmap of the UserAccountDAOImpl class
	   
	   UserAccount obj2 = new UserAccount(); // useraccount object created
	   // saving all the details in obj1
	   obj2.setId(2);
	   obj2.setUserName("Ravi");
	   obj2.setPassword("asdsad43@$#ADA");
	   obj2.setAge(27);
	   obj2.setEmail("ravi@example.com");
	   obj2.setPhoneNumber("9999888811");
	   obj2.setGender("Male");
	   obj2.setCity("Chennai");
	   obj2.setCountry("India");
	   Interest interestObj2 = new Interest(); // Interest obj is created and saved in UserAccount object [obj1]
	   interestObj2.setId(1);
	   interestObj2.setLikes("Cooking");
	   interestObj2.setDislikes("Wasting Time");
	   interestObj2.setHobbies("Collecting coins");
	   interestObj2.setProfileURL("https://findPeople/profile-ravi");
	   interestObj2.setAbout("Passionate Person with new ideas to implement for the country");
	   obj2.setInterest(interestObj2);
	   user.save(obj2); // saving the UserAccount object [obj1] in the hashmap of the UserAccountDAOImpl class
	   
	   System.out.println("User Objects saved");
   }
   
   // findAll method will return all the UserAccount objects
   void findAllUserAccount(UserAccountDAO user) {
	   System.out.println(user.findAll());
   }
   
   // findByID method will; return UserAccount Object with particular ID
   void  findByIDUserAccount(UserAccountDAO user,int id) {
	   System.out.println(user.findByID(id));
   }
   
   // findMatchingUser method will return the UserAccount object with matched data passed as paramter
   void findMatchingUserAccount(UserAccountDAO user,int age, String city) {
	   System.out.println(user.findMatches(age, city));
   }
   
   // deleteUserAccount method will delete the UserAccount Object with particular ID
   void deleteUserAccountObject(UserAccountDAO user,int id) {
	   user.delete(id);
	   System.out.println("User Account with ID: "+id+" is deleted successfully");
   }
   
   
   public static void main(String[] args) {
	int choice;
	Scanner inp = new Scanner(System.in);
	  UserAccountDAO user = new UserAccountDAOImpl(); // for accessing UserAccountDAOImpl methods for performing operations
	while(true) {
	UserAccountController u1 = new UserAccountController();
	System.out.println("Enter your choice: 1 for regsiter user | 2 for fetching all user | 3 for fetching user with ID | 4 for deleting user with ID | 5 for fetching user with age and city | 6 for exit ");
	choice = inp.nextInt();
	if(choice == 6) {
		break;
	}
	switch(choice) {
	case 1:
		u1.register(user);
		break;
	case 2:
		u1.findAllUserAccount(user);
		break;
	case 3:
		int searchID;
		System.out.println("Enter ID of the user to search");
		searchID = inp.nextInt();
		u1.findByIDUserAccount(user,searchID);
		break;
	case 4:
		int deleteID;
		System.out.println("Enter ID of the user to delete");
		deleteID = inp.nextInt();
		u1.deleteUserAccountObject(user,deleteID);
		break;
	case 5:
		int age;
		String city;
		System.out.println("Enter the age of the users to find");
		age = inp.nextInt();
		System.out.println("Ente the city of the users to find");
		inp.nextLine();
		city = inp.nextLine();
		u1.findMatchingUserAccount(user, age, city);
		break;
	default:
		System.out.println("Invalid Option");
	}
	}
 }
}
