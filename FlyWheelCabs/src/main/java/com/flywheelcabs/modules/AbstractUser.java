package com.flywheelcabs.modules;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbstractUser {

	@NotBlank
	@Pattern(regexp = "[a-z]{1,10}_[0-9]{2,5}", message = "The user name should look like---> username_67 <--- and max 10 char and min 2 number max 5 number ")
	private String userName;
  
	@Size(min = 6, max = 15, message = "password length should be in between 6 - 15 character")
	@Pattern(regexp = "[a-z]{2,7}[A-Z]{2,7}[#@$%&*]{1,2}[0-9]{1,9}", message = "password should look like abcABC@999, Morethan 2 lowercase, upercase and number ")
	private String password;

	@Size(max = 10, message = "Not valid mobile number size more than 10 digits")
	private String mobile;

	@Email(message = "Not valid mail id")
	private String email;

	
	private String address;

}
