package de.moscon.etl.steps.testText;

import de.moscon.etl.model.ResultDTO;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class SimpleWriter implements ItemWriter<ResultDTO> {

	@Override
	public void write(List<? extends ResultDTO> messages) {
		System.out.println("---> Writing:");
		for (ResultDTO msg : messages) {
			System.out.println(" --> "+msg.getText()+"-Count:"+msg.getCount());
		}
	}

}
