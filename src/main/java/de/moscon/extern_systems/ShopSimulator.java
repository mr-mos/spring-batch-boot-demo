package de.moscon.extern_systems;

import de.moscon.etl.beans.Product;
import de.moscon.etl.beans.Sale;
import de.moscon.etl.cache.CustomerCache;
import de.moscon.etl.steps.nr01_customerData.CustomerReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class ShopSimulator {

	@Autowired
	CustomerCache customerCache;

	@Autowired
	ProductSimulator productSimulator;

	@Autowired
	CustomerReader customerReader;

	static private List<Sale> CACHE;

	private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");


	public Sale readProductPos(int index) {
		List<Sale> sales = getSales();
		if (index >= sales.size()) {
			return null;
		}
		return sales.get(index);
	}


	/**
	     Generates 2.000 sales transactions randomly
	 */
	private List<Sale> getSales() {
		if (CACHE != null) {
			return CACHE;
		}
		List<Product> products = productSimulator.catchProductList();
		List<Sale> sales = new ArrayList<Sale>();
		Random random = ThreadLocalRandom.current();
		for (int i = 0; i < 2000; i++) {
			Sale sale = new Sale();
			sale.setId(Long.valueOf(i + 1));
			sale.setProductId(Long.valueOf(random.nextInt(100) + 1));
			sale.setCustomerId(Long.valueOf(random.nextInt(1000) + 1));
			// custId exists
			sale.setCount(random.nextInt(12) + 1);
			double priceSum = sale.getCount() * products.get((int) (sale.getProductId() - 1)).getNetPrice();
			sale.setNetPriceSum(priceSum);
			sale.setTime(randomDate(customerCache.getRegistrationDate(sale.getCustomerId())));
			sales.add(sale);
		}
		CACHE = sales;
		return sales;
	}


	private Date randomDate(Date registrationDate) {
		Date startInclusive;
			startInclusive = registrationDate;
		Date endExclusive = new Date();
		long startMillis = startInclusive.getTime();
		long endMillis = endExclusive.getTime();
		long randomMillisSinceEpoch = ThreadLocalRandom.current().nextLong(startMillis, endMillis);
		return new Date(randomMillisSinceEpoch);
	}

}
