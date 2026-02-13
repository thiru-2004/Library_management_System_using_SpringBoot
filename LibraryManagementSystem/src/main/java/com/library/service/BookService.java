package com.library.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.DAO.BookInforamtionDAO;
import com.library.DTO.BookInformationDTO;
import com.library.entity.BookInformation;

@Service
public class BookService 
{
	@Autowired
	BookInforamtionDAO bookInforamtionDAO;
	@Autowired
	ModelMapper mapper;
	
	public boolean addBook(BookInformationDTO bookInformationDTO)
	{
		BookInformation bookInformation=mapper.map(bookInformationDTO, BookInformation.class);
		BookInformation insertbookInformation=bookInforamtionDAO.insertBookDetails(bookInformation);
		if(insertbookInformation!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public List<BookInformation> getAllBookDetails()
	{
		return bookInforamtionDAO.findAllBookDetails();
	}

	public void deleteBookById(int id) 
	{
		
		  bookInforamtionDAO.deleteBookById(id);
		
	}

	public void updateBookDetails(BookInformationDTO bookInformationDTO) 
	{
		BookInformation bookInformation=mapper.map(bookInformationDTO, BookInformation.class);
		BookInformation insertbookInformation=bookInforamtionDAO.updateBookDetails(bookInformation);
		
		
	}

	public Optional<BookInformation> getBookDetailsById(int id) {
		// TODO Auto-generated method stub
		return bookInforamtionDAO.findBookDetailsById(id);
	}
	
	public List<BookInformation> findBookDetailsByUsingTitleOrAutorNameOrLanguage(String filterRequest){
		return bookInforamtionDAO.findBookDetailsByUsingTitleOrAutorNameOrLanguage(filterRequest);
	}

}
