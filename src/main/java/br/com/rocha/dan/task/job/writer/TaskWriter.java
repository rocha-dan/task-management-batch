package br.com.rocha.dan.task.job.writer;

import java.util.List;

import br.com.rocha.dan.task.job.document.TaskDocument;
import org.apache.log4j.Logger;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
@StepScope
public class TaskWriter implements ItemWriter<TaskDocument> {

	private static final Logger log = Logger.getLogger(TaskWriter.class);

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void write(List<? extends TaskDocument> items) throws Exception {
		try {
			log.info("Start Writer" + items.size());

			for (TaskDocument document : items) {
				mongoTemplate.save(document);
			}

		} catch (Exception e) {
			log.error("Error ItemWriter: ", e);
			throw new Exception("Error ItemWriter", e);
		}

	}

}