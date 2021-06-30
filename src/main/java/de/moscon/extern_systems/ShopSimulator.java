package de.moscon.extern_systems;

import de.moscon.etl.beans.Product;
import de.moscon.etl.beans.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class ShopSimulator {

	@Autowired
	ProductSimulator productSimulator;

	static private List<Sale> CACHE;

	static private Map<Long, Date> CACHE_CUSTOMER_FIRST_DATE;

	private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");


	public Sale readProductPos(int index) {
		List<Sale> sales = getSales();
		if (index >= sales.size()) {
			return null;
		}
		return sales.get(index);
	}


	public Date getMinSaleDate(Long customerId) {
		if (CACHE_CUSTOMER_FIRST_DATE == null) {
			generateDataAndInitCaches();
		}
		return CACHE_CUSTOMER_FIRST_DATE.get(customerId);
	}


	private List<Sale> getSales() {
		if (CACHE == null) {
			generateDataAndInitCaches();
		}
		return CACHE;
	}


	/**
	 * Generates 2.000 sales transactions randomly
	 */
	private void generateDataAndInitCaches() {
		Map<Long,Date> firstDates = new HashMap<>();
		List<Product> products = productSimulator.catchProductList();
		List<Sale> sales = new ArrayList<Sale>();
		Random random = ThreadLocalRandom.current();
		for (int i = 0; i < 2000; i++) {
			// 1. create a Sale object
			Sale sale = new Sale();
			sale.setId(Long.valueOf(i + 1));
			sale.setProductId(Long.valueOf(random.nextInt(100) + 1));
			sale.setCustomerId(Long.valueOf(random.nextInt(1000) + 1));
			sale.setCount(random.nextInt(12) + 1);
			double priceSum = sale.getCount() * products.get((int) (sale.getProductId() - 1)).getNetPrice();
			sale.setNetPriceSum(priceSum);
			sale.setTime(randomDate());
			sales.add(sale);
            // 2. remember min sale date
			Date curDate = firstDates.get(sale.getCustomerId());
			if (curDate == null || sale.getTime().before(curDate)) {
				firstDates.put(sale.getCustomerId(),sale.getTime());
			}
		}
		CACHE_CUSTOMER_FIRST_DATE = firstDates;
		CACHE = sales;
	}


	private Date randomDate() {
		Date startInclusive;
		try {
			startInclusive = DATE_FORMAT.parse("01.01.2019");
		} catch (ParseException e) {
			throw new IllegalStateException("Internal unexpected error: " + e);
		}
		Date endExclusive = new Date();
		long startMillis = startInclusive.getTime();
		long endMillis = endExclusive.getTime();
		long randomMillisSinceEpoch = ThreadLocalRandom.current().nextLong(startMillis, endMillis);
		return new Date(randomMillisSinceEpoch);
	}

}
