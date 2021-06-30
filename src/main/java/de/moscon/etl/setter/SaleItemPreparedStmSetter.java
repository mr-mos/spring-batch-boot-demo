package de.moscon.etl.setter;

import de.moscon.etl.beans.Customer;
import de.moscon.etl.beans.Sale;
import de.moscon.etl.utils.DateStringUtils;
import de.moscon.etl.utils.DecimalUtils;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class SaleItemPreparedStmSetter implements ItemPreparedStatementSetter<Sale> {

    DecimalUtils du = new DecimalUtils();
    DateStringUtils dsu = new DateStringUtils();

    @Override
    public void setValues(Sale sale, PreparedStatement ps) throws SQLException {
//        ps.setLong(1, sale.getId());
        ps.setLong(1, sale.getProductId());
        ps.setLong (2, sale.getCustomerId());
        ps.setInt(3, sale.getCount());
        ps.setDouble(4, du.newDouble(sale.getNetPriceSumFormatted()));
        ps.setString(5, dsu.newString(sale.getTimeFormatted()));
    }
}
