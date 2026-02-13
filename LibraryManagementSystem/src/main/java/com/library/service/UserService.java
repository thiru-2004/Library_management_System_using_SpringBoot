package com.library.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.DAO.UserInformationDAO;
import com.library.DTO.UserInformationDTO;
import com.library.entity.UserInformation;

@Service
public class UserService {
	
	@Autowired
	UserInformationDAO userInforamtiondao;
	@Autowired
	ModelMapper mapper;
	public boolean userRegistration(UserInformationDTO informationDTO)
	{
		
		UserInformation information=mapper.map(informationDTO, UserInformation.class);
		UserInformation insertdeatils=userInforamtiondao.insertUserDetails(information);
		if(insertdeatils!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
			
	}
	public boolean checkUserDetails(String emailId, String password)
	{
		
		return userInforamtiondao.getUserDetailsByEmailAndPassword(emailId,password);
		
		
	}

}
