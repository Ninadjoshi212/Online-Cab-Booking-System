package com.flywheelcabs.modules;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Auto Generation/Increment of Cutomer-Id
	private Integer customerId;

}
