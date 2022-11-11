package com.flywheelcabs.modules;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
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
	private Double distanceInKM;
	
	private Double bill;
	
	private LocalDate date;
	
	private LocalTime time;
	
	private LocalDate fromDate;
	
	private LocalDate toDate;
	
	private Integer cabId;
	
	private String carType;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
//	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Driver cabdriver;
	

}
