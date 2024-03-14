package com.mfpe.model;

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
public class AuditQuestion {
    
	@NotEmpty(message="Question Id cannot be empty") 
	@Pattern(regexp="[0-9]{0,2}",message="Question Id is not proper")
	private String questionId;
	
	@NotEmpty(message="Questions cannot be empty") 
	@Pattern(regexp="[a-zA-Z-, ]{0,250}[?]",message="Enter questions properly")
	private String question;
	
	@NotEmpty(message="Audit Type cannot be Empty.") 
	@Pattern(regexp="[a-zA-Z]{0,20}",message="Enter proper Audit Type")
	private String auditType;
	
	@NotEmpty(message="Response cannot be empty") 
	@Pattern(regexp="(YES)|(NO)|(Yes)|(No)",message="Enter only Yes or No")
	private String response;

}
