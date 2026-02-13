package com.library.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookInformationDTO
{
	
	private int bookId;
	@NotBlank(message = "Invalid Book Name")
	private String title;
	@NotBlank(message = "Invalid Author Name")
	private String author;
	@NotBlank(message = "Invalid Genre Name")
	private String genre;
	@NotBlank(message = "Invalid language Name")
	private String language;
	@Min(value = 100)
	private long number_Of_Pages;
	@Min(value = 100)
	private long price;

}
