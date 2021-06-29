package de.moscon.etl.steps.nr01_customerData;

import de.moscon.etl.beans.Customer;
import de.moscon.etl.cache.SaleCache;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

	@Autowired
	SaleCache saleCache;

	@Override
	public Customer process(Customer item) throws Exception {
		item.setPseudonym("customer_"+item.getFirstname().toLowerCase());
		item.setFirstname(null);
		//fix register date (if necessary)
		if (saleCache.getMinOrderDate(item.getId()) != null && item.getRegistrationDate().after(saleCache.getMinOrderDate(item.getId()))) {
			item.setRegistrationDate(saleCache.getMinOrderDate(item.getId()));
		}
		return item;
	}
}
