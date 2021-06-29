package de.moscon.etl.steps.testText;

import de.moscon.etl.model.ResultDTO;
import org.springframework.batch.item.ItemProcessor;

public class SimpleProcessor implements ItemProcessor<String, ResultDTO> {


	@Override
	public ResultDTO process(String data)  {
		if(!data.contains("demo")) {
			ResultDTO result = new ResultDTO();
			result.setText(data.toUpperCase());
			result.setCount();
			return result;
		} else {
			return null;
		}
	}

}
