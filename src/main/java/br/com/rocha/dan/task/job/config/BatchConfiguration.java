package br.com.rocha.dan.task.job.config;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import br.com.rocha.dan.task.job.document.TaskDocument;
import br.com.rocha.dan.task.job.reader.TaskReader;
import br.com.rocha.dan.task.job.writer.TaskWriter;

@Configuration
public class BatchConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private TaskReader dataContingencyReader;

	@Autowired
	private TaskWriter writer;
	
	@Value("${task.batch.chunck}")
	private int totalChunk;

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public Job readPendings() throws Exception {
		return jobBuilderFactory.get("readPendings").flow(step1()).end().build();
	}
	
	@Bean
	@Qualifier("stepPullUpdate")
	public Step step1() throws Exception {
		return stepBuilderFactory.get("step1")
				.<TaskDocument, TaskDocument>chunk(totalChunk)
				.reader(dataContingencyReader.reader())
				.writer(writer)
				.build();
	}
	
	@Bean
	public Client client() throws Exception {
		return ClientBuilder.newClient();
	}
}
