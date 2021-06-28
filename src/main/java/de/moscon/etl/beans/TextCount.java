package de.moscon.etl.beans;

public class TextCount {

	String text;
	Integer count;


	public TextCount(String text, Integer count) {
		this.text = text;
		this.count = count;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
