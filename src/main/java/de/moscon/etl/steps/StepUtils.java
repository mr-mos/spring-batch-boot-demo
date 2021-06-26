package de.moscon.etl.steps;

import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;

public class StepUtils {

	static public DelimitedLineAggregator createLineAggregator(String[] fields) {
		BeanWrapperFieldExtractor beanFieldMapper = new BeanWrapperFieldExtractor();
		beanFieldMapper.setNames(fields);
		DelimitedLineAggregator lineAggregator = new DelimitedLineAggregator();
		lineAggregator.setDelimiter(";");
		lineAggregator.setFieldExtractor(beanFieldMapper);
		return lineAggregator;
	}
}
