package de.moscon.etl.steps.testText;

import org.springframework.batch.item.ItemProcessor;

public class SimpleProcessor implements ItemProcessor<String, String> {


	@Override
	public String process(String data)  {
		return data.toUpperCase();
	}

}
