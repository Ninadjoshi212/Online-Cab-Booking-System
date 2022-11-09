package com.flywheelcabs.modules;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Cab booking entity class which stores the booking data of cabs
//It takes customer id to book any trip;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tripBookingId;
	
	@NotEmpty(message = "startingLocation can not be empty")
	private String startingLocation;
	
	@NotEmpty(message = "destination can not be empty")
	private String destination;
	
	@NotNull(message = "distance value cannot be null")
	private Integer distanceInKM;
	private Double bill;
	
//	@ManyToOne
//	private Customer customer;
	
//	@ManyToOne
//	private Driver driver;
	

}
