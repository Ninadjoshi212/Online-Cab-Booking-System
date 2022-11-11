//package com.flywheelcabs.modules;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Embedded;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToOne;
//import javax.validation.constraints.NotNull;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.NoArgsConstructor;
//import lombok.ToString;
//
//@Data
//@EqualsAndHashCode(callSuper = true)
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//@Entity
//public class Driver extends AbstractUser{
//
//		@Id
//		@GeneratedValue(strategy = GenerationType.AUTO) // Auto Generation/Increment of Cutomer-Id
//		private Integer driverId;
//		
//		@Column(unique = true)
//		@NotNull
//		private String licenceNo;
//		
////		@OneToOne(cascade = CascadeType.ALL)
////		private Cab cab;
//		
//		private float perkmRate;
//		
////		@Embedded
////		private AbstractUser abstractuser;
//
//
//}
