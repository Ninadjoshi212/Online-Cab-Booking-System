package com.flywheelcabs.modules;

import javax.persistence.Column;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
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
	
	
	 private boolean available = true;
	
	private Float rating;
	
	@Column(unique = true)
	@NotNull
	@Pattern(regexp = "[A-Z]{2}[0-9]{8}", message = "password should look like KA09834567, 2 alphabet and 8 numbers ")
	private String licenceNo;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cabdriver", orphanRemoval = true)
	private List<TripDetails> tripList = new ArrayList<>();
	
//	@Embedded
//	private AbstractUser user;
	
//	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL ,orphanRemoval = true)
	private Cab cab;

}
