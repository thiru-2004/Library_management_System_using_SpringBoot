package com.library.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.library.entity.UserInformation;
import com.library.repo.UserRepo;

@Repository
public class UserInformationDAO {

	@Autowired
	UserRepo userRepo;

	public UserInformation insertUserDetails(UserInformation information) {
		return userRepo.save(information);
	}

	public boolean getUserDetailsByEmailAndPassword(String emailId, String password) 
	{
		
		return userRepo.existsByEmailAndPassword(emailId, password);
		
	}

}
