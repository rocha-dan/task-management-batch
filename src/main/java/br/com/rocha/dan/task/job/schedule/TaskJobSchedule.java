package br.com.rocha.dan.task.job.schedule;

import java.util.Date;

import br.com.rocha.dan.task.job.document.TaskDocument;
import br.com.rocha.dan.task.job.processor.TaskProcessor;
import br.com.rocha.dan.task.job.reader.TaskReader;
import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import br.com.rocha.dan.task.job.writer.TaskWriter;

@EnableScheduling
@Configuration
@EnableBatchProcessing
public class TaskJobSchedule {
	
	private static final Logger log = Logger.getLogger(TaskJobSchedule.class);
	
	@Autowired
    private JobLauncher jobLauncher;

	@Autowired
	@Qualifier("stepPullUpdate")
	private Step step;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private TaskProcessor orderProcessor;
    
	@Autowired
	private TaskReader fraudScreeningReader;

	@Autowired
	private TaskWriter fraudScreeningWriter;
	
	@Value("${task.batch.chunck}")
	private int totalChunk;
	
	@Scheduled(cron = "${cron}")
	public void run() throws Exception {
				
		try {
						
            log.info("Start Launcher scheduled");
            
            String dateParam = new Date().toString();
            
            JobParameters param = new JobParametersBuilder().addString("date", dateParam).toJobParameters();
            
            Step step = stepBuilderFactory.get("step1")
    				.<TaskDocument, TaskDocument>chunk(totalChunk)
    				.reader(fraudScreeningReader.reader())
    				.processor(orderProcessor)
    				.writer(fraudScreeningWriter)
    				.build();
            
            Job job = jobBuilderFactory.get("readPendings").flow(step).end().build();
            
            JobExecution execution = jobLauncher.run(job,param);
            log.info("Finish Launcher scheduled : " + execution.getStatus());
            

        } catch (Exception e) {
        	log.error(e);
        	throw e;
        }
	}
	
}
