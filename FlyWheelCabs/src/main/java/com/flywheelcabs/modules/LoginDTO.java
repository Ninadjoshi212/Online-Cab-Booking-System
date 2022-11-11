 package com.flywheelcabs.modules;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {

	@NotEmpty(message = "mobile number can not be Empty")
	@NotNull(message = "mobile number can not be null")
	private String mobileNumber;
	
	@Size(min = 6, max = 15, message = "Password length should be 6 - 15 character")
	@NotBlank
	@Pattern(regexp = "[a-z]{2,7}[A-Z]{2,7}[#@$%&*]{1,2}[0-9]{1,9}", message = "password should look like abcABC@999, Morethan 2 lowercase, upercase and number ")
	private String password;
	
	
}
