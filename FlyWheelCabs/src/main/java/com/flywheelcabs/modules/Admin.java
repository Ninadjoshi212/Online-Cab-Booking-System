package com.flywheelcabs.modules;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor 
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
public class Admin extends AbstractUser{
	
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
     private Integer adminId;
     private String name;
 

}
