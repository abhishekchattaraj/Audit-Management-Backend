package com.mfpe.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class AuthenticationRequest {
	
	@NotEmpty(message="Username cannot be Empty.") @Pattern(regexp="[a-zA-Z]{0,20}",message="Username can only be alphabets and length cannot be more than 20")
	private String username;
	@NotEmpty(message="Password cannot be Empty.") @Pattern(regexp="[a-zA-Z0-9]{0,20}",message="Password cannot be a special character and length cannot be more than 20")
	private String password;
}
