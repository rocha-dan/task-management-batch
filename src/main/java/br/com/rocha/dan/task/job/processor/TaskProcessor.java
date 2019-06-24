package br.com.rocha.dan.task.job.processor;

import org.apache.log4j.Logger;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import br.com.rocha.dan.task.job.document.TaskDocument;

@StepScope
@Component
public class TaskProcessor implements ItemProcessor<TaskDocument, TaskDocument> {

	private static final Logger log = Logger.getLogger(TaskProcessor.class);

	@Override
	public TaskDocument process(TaskDocument orderDocument) throws Exception {
		
		log.info("Start Process Method");

		//logic

		log.info("Finish Process Method");

		return orderDocument;

	}

}
