package de.moscon.etl.steps.testText;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class SimpleWriter implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> messages) {
		System.out.println("---> Writing:");
		for (String msg : messages) {
			System.out.println(" --> "+msg);
		}
	}

}
