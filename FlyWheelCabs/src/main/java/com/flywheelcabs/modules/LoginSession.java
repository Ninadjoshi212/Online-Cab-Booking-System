package com.flywheelcabs.modules;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginSession {

	private Integer userId;
	private String userUniqueId;
	private LocalDateTime loginTime;
	private String type;
	
}
