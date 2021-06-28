package de.moscon.etl.steps.testText;

import de.moscon.etl.beans.TextCount;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class SimpleWriter implements ItemWriter<TextCount> {

	@Override
	public void write(List<? extends TextCount> messages) {
		System.out.println("---> Writing:");
		for (TextCount msg : messages) {
			System.out.println(" --> " + msg.getText() + " -->Count: " + msg.getCount());
		}
	}

}
