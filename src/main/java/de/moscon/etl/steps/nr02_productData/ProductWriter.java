package de.moscon.etl.steps.nr02_productData;

import de.moscon.etl.beans.Product;
import de.moscon.etl.steps.StepUtils;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class ProductWriter extends FlatFileItemWriter<Product> {

	private Resource outputResource = new FileSystemResource("data/output/produkte_tennisshop.csv");

	public ProductWriter() {
		setResource(outputResource);
		setLineAggregator(StepUtils.createLineAggregator(getFields()));
		setHeaderCallback(writer -> {
			writer.write(String.join(";", getFields()));
		});
	}



	private String[] getFields() {
		return new String[]{"id", "displayName", "netPriceFormatted", "category", "playerBrand"};
	}

}
