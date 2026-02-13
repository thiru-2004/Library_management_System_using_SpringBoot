package com.library.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.DAO.AdminDAO;
import com.library.entity.AdminInformation;

@Service
public class AdminService
{
	
	@Autowired
	AdminDAO adminDAO;
	
	public boolean admindetails(int adminId)
	{
		Optional<AdminInformation> adminOptional=adminDAO.getAdminDetails(adminId);
		System.out.println(adminOptional);
		if(adminOptional.isPresent())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
