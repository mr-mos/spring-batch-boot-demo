package de.moscon.etl.beans;

import de.moscon.etl.beans.enums.Gender;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {

	private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

	private Long id;
	private String firstname;
	private String pseudonym;
	private Gender gender;
	private Date birthday;

	private String zipCode;
	private String city;

	private Date registrationDate;


	public String getBirthdayFormatted() {
		return DATE_FORMAT.format(getBirthday());
	}

	public String getRegistrationDateFormatted() {
		return DATE_FORMAT.format(getRegistrationDate());
	}


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPseudonym() {
		return pseudonym;
	}

	public void setPseudonym(String pseudonym) {
		this.pseudonym = pseudonym;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
