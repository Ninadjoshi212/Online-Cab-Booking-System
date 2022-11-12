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

	@Size(min = 3, max = 20, message = "Username length should be in between 3 to 20 characters")
	@NotBlank(message = "username must not be blank")
	private String userName;

	@Size(min = 6, max = 15, message = "password length should be in between 6 - 15 character")
	@Pattern(regexp = "[a-z]{2,7}[A-Z]{2,7}[#@$%&*]{1,2}[0-9]{1,9}", message = "password should look like abcABC999, Morethan 2 lowercase, upercase and number ")
	@NotBlank(message = "password must not be blank")
	private String password;

	@Size(max = 10, message = "Not valid mobile number size more than 10 digits")
	@NotBlank(message = "mobile must not be blank")
	private String mobile;

	@Email(message = "Not valid mail id")
	@NotBlank(message = "email must not be blank")
	private String email;

	@NotBlank(message = "address must not be blank")
	private String address;

}
