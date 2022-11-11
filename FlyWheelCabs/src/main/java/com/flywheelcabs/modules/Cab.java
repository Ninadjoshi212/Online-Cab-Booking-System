package com.flywheelcabs.modules;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@NotNull(message = "Per Kilometer rate can not be null or empty")
	private float perKmRate;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "cab" )
	private Driver diver;

}
