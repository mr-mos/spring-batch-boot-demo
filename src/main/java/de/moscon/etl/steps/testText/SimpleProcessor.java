package de.moscon.etl.steps.testText;

import de.moscon.etl.beans.TextCount;
import org.springframework.batch.item.ItemProcessor;

public class SimpleProcessor implements ItemProcessor<String, TextCount> {


	@Override
	public TextCount process(String data)  {
		if (data != null && data.contains("demo")) {
			return null;
		}
		return new TextCount(data.toUpperCase(),data.length());
	}

}
