package com.library.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.DTO.UserInformationDTO;
import com.library.entity.BookInformation;
import com.library.service.BookService;
import com.library.service.UserService;

import jakarta.validation.Valid;

@Controller
//@RequestMapping("/user")
public class UserController
{

   
	
	@RequestMapping("/userregistrationpage")
	public String userRegistrationPage()
	{
		return "UserRegistration";
	}
	
	@Autowired
	UserService service;
	
	//@ResponseBody
	@RequestMapping("/userregistrationResult")
	public String userRegistration(@Valid  UserInformationDTO userInformationdto)
	{
		if(service.userRegistration(userInformationdto))
		{
			return "UserLogin";
		}
		
		else
		{
			return "Server Error";
		}
		
	}
	
	@RequestMapping("/userloginpage")
	public String userLoginPage()
	{
		
		return "UserLogin";
	}
	
	@Autowired
	BookService bookService;
	//@ResponseBody
	@RequestMapping("/userlogin")
	public String userLogin(String emailId,String password,Model model)
	{
		System.out.println(emailId+" "+password);
		if(service.checkUserDetails(emailId,password))
		{
			List<BookInformation> allbookdetils = bookService.getAllBookDetails();
			model.addAttribute("AllBookDetails", allbookdetils);
			return "AllBookDetailsForUser";
		}
		else
		{
		return "LoginFailed";
		}
	}
	
	

}
