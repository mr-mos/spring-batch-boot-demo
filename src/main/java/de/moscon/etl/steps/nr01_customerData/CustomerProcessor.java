package de.moscon.etl.steps.nr01_customerData;

import de.moscon.etl.beans.Customer;
import de.moscon.extern_systems.ShopSimulator;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

	@Autowired
	ShopSimulator shopSimulator;

	@Override
	public Customer process(Customer item) throws Exception {
		item.setPseudonym("customer_"+item.getId());
		item.setFirstname(null);

		Date firstBuy = shopSimulator.getFirstBuy(item.getId());
		if (firstBuy.before(item.getRegistrationDate())) {
			item.setRegistrationDate(firstBuy);
		}

		return item;
	}
}
