package com.library.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
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
public class UserInformationDTO 
{
	
	private int userid;
	@NotBlank(message = "Invalid First Name")
	private String fn;
	@NotBlank(message = "Invalid Last Name")
	private String ln;
	@Email(message = "Invalid Email Id")
	private String email;
	private String password;
	@Max(value = 9999999999l,message = "Invalid Mobile Number")
	@Min(value = 6000000000l,message = "Invalid Mobile Number")
	private long mb;
	@NotBlank(message = "Invalid  Gender")
	private String gender;
	
	

}
