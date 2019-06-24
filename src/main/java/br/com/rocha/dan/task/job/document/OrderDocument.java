package br.com.rocha.dan.task.job.document;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="OrderScreening")
public class OrderDocument implements Serializable {

	private static final long serialVersionUID = -2843210987023266541L;

	@Id
	private String _id;
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