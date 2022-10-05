package com.karthik.findPeople.dao;

import java.util.Map;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.karthik.findPeople.model.UserAccount;

public class UserAccountDAOImpl implements UserAccountDAO{

	// Hashmap for storing user accounts objects
	Map<Integer, UserAccount> userAccountStored = new HashMap<>();
	
	@Override
	public void save(UserAccount userAccount) {
		userAccountStored.put(userAccount.getId(), userAccount); // will store the useraccount object's "id as key" and "useraccount object as data" in hashmap
	    
	}
	
	@Override
	public UserAccount findByID(int id) {
		return userAccountStored.get(id); // will return the useraccount object with particular ID
	}
	
	@Override
	public List<UserAccount> findAll(){
		
		return new ArrayList<UserAccount>(userAccountStored.values()); // will return all the userAccounts objects stored in hashmap as an arraylist
	}
	
	@Override
	// "findMatches" method will return the useraccount objects that matches the age and city passed as paramter
	public List<UserAccount> findMatches(int age, String city){
		Collection<UserAccount> accounts = userAccountStored.values(); 
		ArrayList<UserAccount> matchesFound = new ArrayList<UserAccount>();
		for(UserAccount acc: accounts) {
			if(acc.getAge() == age && acc.getCity().equals(city) ) {
			     matchesFound.add(acc);	
			}
		}
		return matchesFound;
	}
	
	@Override
	// "delete" method will delete the useraccounts object with particular id passed as parameter 
	public void delete(int id) {
		userAccountStored.remove(id);
	}
	
    
}
