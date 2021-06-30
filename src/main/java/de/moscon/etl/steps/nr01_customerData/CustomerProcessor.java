package de.moscon.etl.steps.nr01_customerData;

import de.moscon.etl.beans.Customer;
import de.moscon.extern_systems.ShopSimulator;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

	@Autowired
	ShopSimulator shopSimulator;

	@Override
	public Customer process(Customer customer) throws Exception {
		customer.setPseudonym("customer_"+customer.getId());
		customer.setFirstname(null);
		Date firstTransactionDate = shopSimulator.getMinSaleDate(customer.getId());
		if (firstTransactionDate != null && firstTransactionDate.before(customer.getRegistrationDate())) {
			customer.setRegistrationDate(firstTransactionDate);
		}
		return customer;
	}
}
