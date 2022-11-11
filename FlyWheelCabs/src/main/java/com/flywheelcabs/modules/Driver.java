package com.flywheelcabs.modules;

import javax.persistence.Column;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Driver extends AbstractUser{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer driverId;
	
	
	 
	
	private Float rating;
	
	@Column(unique = true)
	@NotNull
	private String licenceNo;
	
	
	
//	@Embedded
//	private AbstractUser user;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	private Cab cab;

}
