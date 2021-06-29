package de.moscon.etl.steps.nr03_salesData;

import de.moscon.etl.beans.Product;
import de.moscon.etl.beans.Sale;
import de.moscon.etl.cache.SaleCache;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SalesProcessor implements ItemProcessor<Sale, Sale> {

	@Autowired
	SaleCache saleCache;

	@Override
	public Sale process(Sale item)  {
		//item.getCustomerId();
		Date minOrderDate = saleCache.getMinOrderDate(item.getCustomerId());
		if (minOrderDate == null) {
			saleCache.addToSaleCache(item.getCustomerId(), item.getTime());
		} else {
			if (item.getTime().before(minOrderDate)) {
				saleCache.addToSaleCache(item.getCustomerId(), item.getTime());
			}
		}
		return item;
	}
}
