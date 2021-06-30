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
	public Customer process(Customer item) throws Exception {
		shopSimulator.generateMinSaleDates();
		Date minDate = shopSimulator.getMinSaleDate(item.getId());
		item.setPseudonym("customer_"+item.getFirstname().toLowerCase());
		item.setFirstname(null);
		if(minDate!=null){
			if(!item.getRegistrationDate().before(minDate)){
				item.setRegistrationDate(minDate);
			}}
		return item;
	}
}
