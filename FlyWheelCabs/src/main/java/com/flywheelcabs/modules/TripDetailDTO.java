package com.flywheelcabs.modules;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripDetailDTO {
	
	@NotEmpty(message = "startingLocation can not be empty")
     private String startingLocation;
	
	@NotEmpty(message = "destination can not be empty")
	private String destination;
	
	@NotEmpty(message = "Mobilenumber cannot be empty")
	private String mobileNumber;
	
	@NotNull
	private Integer customerId;
}
