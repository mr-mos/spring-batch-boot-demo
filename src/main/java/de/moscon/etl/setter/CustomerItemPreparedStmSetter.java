package de.moscon.etl.setter;

import de.moscon.etl.beans.Customer;
import de.moscon.etl.utils.DateStringUtils;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CustomerItemPreparedStmSetter implements ItemPreparedStatementSetter<Customer> {

    DateStringUtils dsu = new DateStringUtils();

    @Override
    public void setValues(Customer customer, PreparedStatement ps) throws SQLException {
//        ps.setLong(1, customer.getId());
        ps.setString(1, customer.getPseudonym());
        ps.setString (2, customer.getGender().name());
        ps.setString(3, dsu.newString(customer.getRegistrationDateFormatted()));
        ps.setString(4, customer.getZipCode());
        ps.setString(5, customer.getCity());
        ps.setString(6, dsu.newString(customer.getRegistrationDateFormatted()));
    }
}
