package de.moscon.etl.steps.nr03_salesData;

import de.moscon.etl.beans.Sale;
import de.moscon.etl.steps.StepUtils;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class SalesWriter extends FlatFileItemWriter<Sale> {

	private Resource outputResource = new FileSystemResource("data/output/sales_tennisshop.csv");

	public SalesWriter() {
		setResource(outputResource);
		setLineAggregator(StepUtils.createLineAggregator(getFields()));
		setHeaderCallback(writer -> {
			writer.write(String.join(";", getFields()));
		});
	}



	private String[] getFields() {
		return new String[]{"id", "productId", "customerId", "count", "netPriceSumFormatted", "timeFormatted"};
	}

}
