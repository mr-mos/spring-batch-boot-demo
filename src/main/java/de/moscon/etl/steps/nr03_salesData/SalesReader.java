package de.moscon.etl.steps.nr03_salesData;

import de.moscon.etl.beans.Sale;
import de.moscon.extern_systems.ShopSimulator;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

@Component
public class SalesReader implements ItemReader<Sale> {

	private ShopSimulator shopSimulator;

	int nextSalesIndex = 0;


	public SalesReader(ShopSimulator productSimulator) {
		this.shopSimulator = productSimulator;
	}

	@Override
	public Sale read() {
		return shopSimulator.readProductPos(nextSalesIndex++);
	}
}
