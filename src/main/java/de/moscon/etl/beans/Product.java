package de.moscon.etl.beans;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Product {

	private static DecimalFormat NUMBER_FORMAT;

	static {
		NUMBER_FORMAT = (DecimalFormat)NumberFormat.getNumberInstance(Locale.GERMAN);
		NUMBER_FORMAT.setMaximumFractionDigits(2);
		NUMBER_FORMAT.setMinimumFractionDigits(2);
	}

	private Long id;
	private String displayName;    // not available in the org-data
	private double netPrice;

	private String category;
	private String playerBrand;


	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPlayerBrand() {
		return playerBrand;
	}

	public void setPlayerBrand(String playerBrand) {
		this.playerBrand = playerBrand;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public double getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(double netPrice) {
		this.netPrice = netPrice;
	}

	public String getNetPriceFormatted() {
		return NUMBER_FORMAT.format(getNetPrice());
	}
}
