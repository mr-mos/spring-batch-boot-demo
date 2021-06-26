package de.moscon.etl.steps.nr02_productData;

import de.moscon.etl.beans.Product;
import de.moscon.extern_systems.ProductSimulator;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

@Component
public class ProductReader implements ItemReader<Product> {

	private ProductSimulator productSimulator;

	int nextProductIndex = 0;



	public ProductReader(ProductSimulator productSimulator) {
		this.productSimulator = productSimulator;
	}

	@Override
	public Product read()  {
		return productSimulator.readProductPos(nextProductIndex++);
	}
}
