package br.com.rocha.dan.task.job.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.data.MongoItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import br.com.rocha.dan.task.job.document.OrderDocument;

@Component
public class FraudScreeningReader {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Value("${collection.order.screening:OrderScreening}")
    private String collection;
		
	@Bean
	@StepScope
	  public MongoItemReader<OrderDocument> reader() {
	
		MongoItemReader<OrderDocument> reader = new MongoItemReader();
		reader.setTemplate(mongoTemplate);
		reader.setTargetType(OrderDocument.class);
		reader.setCollection(collection);
		reader.setQuery("{systemResponse: 'INVESTIGATE' }");

 		return reader;
	  }
}
