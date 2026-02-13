package com.library.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.library.entity.BookInformation;
import com.library.repo.BookRepo;

@Repository
public class BookInforamtionDAO {
	@Autowired
	BookRepo bookrepo;

	public BookInformation insertBookDetails(BookInformation information) {
		return bookrepo.save(information);
	}

	public List<BookInformation> findAllBookDetails() {
		return bookrepo.findAll();
	}

	public void deleteBookById(int id) {
		
		
		 bookrepo.deleteById(id);;
	}

	public BookInformation updateBookDetails(BookInformation bookInformation) 
	{
		
		return bookrepo.save(bookInformation);
	}

	public Optional<BookInformation> findBookDetailsById(int id) {
		
		return bookrepo.findById(id);
	}
	
	public List<BookInformation> findBookDetailsByUsingTitleOrAutorNameOrLanguage(String filterRequest){
		return bookrepo.findByTitleOrAuthorOrLanguage(filterRequest);
	}

}
