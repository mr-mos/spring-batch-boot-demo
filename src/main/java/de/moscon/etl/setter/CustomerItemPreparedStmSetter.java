package de.moscon.etl.setter;

import de.moscon.etl.beans.Customer;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerItemPreparedStmSetter implements ItemPreparedStatementSetter<Customer> {

    @Override
    public void setValues(Customer customer, PreparedStatement ps) throws SQLException {
//        ps.setLong(1, customer.getId());
        ps.setString(1, customer.getPseudonym());
        ps.setString (2, customer.getGender().name());
        ps.setString(3, customer.getBirthdayFormatted());
        ps.setString(4, customer.getZipCode());
        ps.setString(5, customer.getCity());
        ps.setString(6, customer.getRegistrationDateFormatted());
    }
}
