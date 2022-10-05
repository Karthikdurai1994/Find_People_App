package com.karthik.findPeople.dao;

import java.util.List;

import com.karthik.findPeople.model.UserAccount;

public interface UserAccountDAO {
	// "save" method for storing useraccount object
    void save(UserAccount userAccount);
    
    // "findByID" method will return the useraccount object with the particular ID passed
    UserAccount findByID(int id);
    
    // "findAll" method will return all the stored useraccount object
    List<UserAccount> findAll();
    
    // "findMatches" method for gettinf useraccount objects that matches age and city passed as parameter
    List<UserAccount> findMatches(int age, String city);
    
    // "delete" method will delete the userobject with id passed as parameter 
    void delete(int id);
}
