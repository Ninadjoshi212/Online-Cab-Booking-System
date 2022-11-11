package com.flywheelcabs.modules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
	
	private Integer numberOfTrip;
	private Double totalDistance;
	
	private Double avarageDistanceTravel;
	
	private Double avarageRatePerKM;
	
	private Double totalfare;

}
