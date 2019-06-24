package br.com.rocha.dan.task.job.model;

import lombok.Data;

@Data
public class PullUpdateResponse {
	
	private String id;
	private String modelCode;
	private Long modelVersion;
	private String orgCode;
	private String time;
	private Long score;
	private Long tdl;
	private String systemResponse;
	private String fulfillmentAction;
	private String riskLevel;
	
}
