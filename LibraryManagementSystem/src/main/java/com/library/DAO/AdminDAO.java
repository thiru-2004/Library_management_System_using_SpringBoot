package com.library.DAO;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.library.entity.AdminInformation;
import com.library.repo.AdminRepo;

@Repository
public class AdminDAO 
{
	@Autowired
	AdminRepo adminRepo;
	
	public Optional<AdminInformation>  getAdminDetails(int admiid)
	{
		Optional<AdminInformation> adminInformation= adminRepo.findById(admiid);
		return adminInformation;
	}

}
