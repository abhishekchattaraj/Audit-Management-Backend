package com.mfpe.model;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditRequest {
   
	@NotEmpty(message="Project Name cannot be Empty.") 
	@Pattern(regexp="[a-zA-Z]{1,20}-[0-9]{1,}",message="Project Name should be entered in proper format")
	private String projectName;
	@NotEmpty(message="Manager Name cannot be Empty.") 
	@Pattern(regexp="[a-zA-Z]{1,20} [a-zA-Z]{1,20}",message="Manager Name can only be alphabets and length cannot be more than 20")
	private String managerName;
	
	@Valid
	private AuditDetail auditDetail;
	

}
