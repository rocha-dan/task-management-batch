package br.com.rocha.dan.task.job.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorizationResponseTO {

	  private String accessToken;
	  private String tokenType;
	  private String expiresIn;
	  private List<String> scope;
	
}
