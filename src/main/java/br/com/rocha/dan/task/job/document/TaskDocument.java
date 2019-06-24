package br.com.rocha.dan.task.job.document;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="Task")
public class TaskDocument implements Serializable {

	private static final long serialVersionUID = -2843210987023266541L;

	@Id
	private String id;
	private String title;
	private String name;
	private String description;
	private LocalDateTime scheduledDate;

}