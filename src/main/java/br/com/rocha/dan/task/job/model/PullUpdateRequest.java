package br.com.rocha.dan.task.job.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PullUpdateRequest {
	
	private String documentBase;
	private String orgCode;
}
