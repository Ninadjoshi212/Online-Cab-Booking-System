package com.flywheelcabs.modules;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cab {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cabId;
	
	@NotNull(message = "Car type should not be null")
	@Pattern(regexp="^(?i)(Mini|Sedan|SUV)$",message="Car type should be one of the Mini,Sedan and SUV")
	private String carType;
	
	
	private float perKmRate;
	

}
