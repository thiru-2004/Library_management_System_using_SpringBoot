package com.library.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.library.entity.BookInformation;


public interface BookRepo extends JpaRepository<BookInformation, Integer>
{
	
	@Query("select book from BookInformation book where book.title=?1or book.author=?1 or book.language=?1")
	List<BookInformation> findByTitleOrAuthorOrLanguage(String filterRequest);

}
