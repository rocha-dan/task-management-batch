package br.com.rocha.dan.task.job.processor;

import org.apache.log4j.Logger;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.rocha.dan.task.job.document.OrderDocument;
import br.com.rocha.dan.task.job.model.PullUpdateRequest;
import br.com.rocha.dan.task.job.model.PullUpdateResponses;

@StepScope
@Component
public class OrderProcessor implements ItemProcessor<OrderDocument, OrderDocument> {

	private static final Logger log = Logger.getLogger(OrderProcessor.class);
	private static final String ORGCODE = "SERASA01";
	private static final String DOCUMENTBASE = "LOJACS";

	@Override
	public OrderDocument process(OrderDocument orderDocument) throws Exception {
		
		log.info("Start Process Method");

		PullUpdateRequest pullUpdate = new PullUpdateRequest(DOCUMENTBASE, ORGCODE);

		log.info("Finish Process Method");

		return orderDocument;

	}

}
