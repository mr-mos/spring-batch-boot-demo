package de.moscon.etl.steps.nr02_productData;

import de.moscon.etl.beans.Product;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class ProductProcessor implements ItemProcessor<Product, Product> {


	@Override
	public Product process(Product item)  {
		item.setDisplayName(item.getCategory()+": "+item.getPlayerBrand());
		return item;
	}
}
