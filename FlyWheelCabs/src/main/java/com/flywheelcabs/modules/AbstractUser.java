package com.flywheelcabs.modules;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbstractUser {

//	@Size(min = 3, max = 20, message = "Username should be between 3 to 20 characters")
//	@NotBlank
	private String userName;

//	@Size(min = 8, max = 15, message = "Not a valid password")
	private String password;

//	@Size(max = 10, message = "Not valid mobile number of max 10 digits")
	private String mobile;

//	@Email(message = "Not valid mail id")
	private String email;

//	@NotBlank
//	@NotNull
	private String address;

}
