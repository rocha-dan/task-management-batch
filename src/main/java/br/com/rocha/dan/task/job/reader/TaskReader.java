package br.com.rocha.dan.task.job.reader;

import br.com.rocha.dan.task.job.document.TaskDocument;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.data.MongoItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class TaskReader {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Value("${collection.task}")
    private String collection;
		
	@Bean
	@StepScope
	  public MongoItemReader<TaskDocument> reader() {
	
		MongoItemReader<TaskDocument> reader = new MongoItemReader();
		reader.setTemplate(mongoTemplate);
		reader.setTargetType(TaskDocument.class);
		reader.setCollection(collection);

//		List<Object> param = new ArrayList<Object>();
//		param.add(LocalDateTime.now());
//		reader.setParameterValues(param);
		reader.setQuery("{}");

 		return reader;
	  }
}
