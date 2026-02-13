package com.library.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entity.UserInformation;
import java.util.List;



public interface UserRepo  extends JpaRepository<UserInformation, Integer>
{
	
	public boolean  existsByEmailAndPassword(String email, String password);
	
	

}
