package com.mfpe.model;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class AuditDetail {
    
	@NotEmpty(message="Audit Type cannot be Empty.") 
	@Pattern(regexp="[a-zA-Z]{1,20}",message="Enter proper Audit Type")
	private String auditType;
	
	@Nullable
	private Date auditDate;
	
	@Valid
	private List<AuditQuestion> auditQuestions;
}
