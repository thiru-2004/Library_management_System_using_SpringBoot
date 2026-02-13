package com.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.DTO.BookInformationDTO;
import com.library.entity.BookInformation;
import com.library.exception.BookDataExceptionHandler;
import com.library.service.AdminService;
import com.library.service.BookService;

import jakarta.validation.Valid;

@Controller
//@RequestMapping("/admin")
public class ÁdminController {

	

	@RequestMapping("/addbook")
	public String addBookPage() {
		return "AddBook";
	}

	@Autowired
	BookService bookService;

	@RequestMapping("/addbookresult")
	public String addBook(@Valid BookInformationDTO bookInformationDTO, Model model) {
		System.out.println(bookInformationDTO);
		List<BookInformation> allbookdetils = bookService.getAllBookDetails();
		model.addAttribute("AllBookDetails", allbookdetils);
		if (bookService.addBook(bookInformationDTO)) {
			return "DisplyAllBookDetails";
		} else {
			return "Server Error";
		}
	}

	@RequestMapping("/adminloginpage")
	public String adminLoginPage() {
		return "AdminLoginPage";
	}

	@Autowired
	AdminService adminService;

	@RequestMapping("/adminlogin")
	public String adminLogin(Integer adminid) {

		if (adminService.admindetails(adminid)) {
			System.out.println(adminService.admindetails(adminid));
			return "AddBook";
		} else {
			return "Server Error";
		}
	}

	@RequestMapping("/deleteBook")
	public String deleteBookDetails(int id, Model model) {

		bookService.deleteBookById(id);
		List<BookInformation> allbookdetils = bookService.getAllBookDetails();
		model.addAttribute("AllBookDetails", allbookdetils);
		return "DisplyAllBookDetails";

	}

	@RequestMapping("/updateBook")
	public String updateBookDetailsPage(Integer id, Model model) {

		Optional<BookInformation> optionalBook = bookService.getBookDetailsById(id);

		if (optionalBook.isPresent()) {
			BookInformation existingBook = optionalBook.get();

			model.addAttribute("book", existingBook);
			return "UpdateBookDetails";
		} else {

			return "redirect:/displayAllBooks";

		}
	}

	@RequestMapping("/updateBookDetails")
	public String updateBookDetails(@Valid BookInformationDTO bookInformationDTO, Model model) {

		bookService.updateBookDetails(bookInformationDTO);
		List<BookInformation> allbookdetils = bookService.getAllBookDetails();
		model.addAttribute("AllBookDetails", allbookdetils);
		return "DisplyAllBookDetails";
	}
	
	@RequestMapping("/filterbookdetails")
	public String filterBookDetails(String searchQuery,Model model)
	{
		if(!searchQuery.isEmpty())
		{
		List<BookInformation> allbookdetils = bookService.findBookDetailsByUsingTitleOrAutorNameOrLanguage(searchQuery);
		model.addAttribute("AllBookDetails", allbookdetils);
		return "AllBookDetailsForUser";
		}
		else
		{
			List<BookInformation> allbookdetils = bookService.getAllBookDetails();
			model.addAttribute("AllBookDetails", allbookdetils);
			return "AllBookDetailsForUser";
		}
	}

}
