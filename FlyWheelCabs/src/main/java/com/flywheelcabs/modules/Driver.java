package com.flywheelcabs.modules;

import javax.persistence.Column;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

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
