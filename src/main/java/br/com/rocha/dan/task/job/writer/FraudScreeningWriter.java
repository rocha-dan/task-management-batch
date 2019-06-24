package br.com.rocha.dan.task.job.writer;

import java.util.List;

import br.com.rocha.dan.task.job.document.OrderDocument;
import org.apache.log4j.Logger;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
@StepScope
public class FraudScreeningWriter implements ItemWriter<OrderDocument> {

	private static final Logger log = Logger.getLogger(FraudScreeningWriter.class);

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void write(List<? extends OrderDocument> items) throws Exception {
		try {
			log.info("Start Writer" + items.size());

			for (OrderDocument document : items) {
				mongoTemplate.save(document);
			}

		} catch (Exception e) {
			log.error("Error ItemWriter: ", e);
			throw new Exception("Error ItemWriter", e);
		}

	}

}