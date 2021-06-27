package de.moscon.etl.beans;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Sale {

	private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

	private static DecimalFormat NUMBER_FORMAT;

	static {
		NUMBER_FORMAT = (DecimalFormat) NumberFormat.getNumberInstance(Locale.GERMAN);
		NUMBER_FORMAT.setMaximumFractionDigits(2);
		NUMBER_FORMAT.setMinimumFractionDigits(2);
	}

	private Long id;

	private Long productId;
	private Long customerId;

	private int count;
	private double netPriceSum;

	private Date time;


	public String getTimeFormatted() {
		return DATE_FORMAT.format(getTime());
	}

	public String getNetPriceSumFormatted() {
		return NUMBER_FORMAT.format(netPriceSum);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getNetPriceSum() {
		return netPriceSum;
	}

	public void setNetPriceSum(double netPriceSum) {
		this.netPriceSum = netPriceSum;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
