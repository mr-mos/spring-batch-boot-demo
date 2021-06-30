package de.moscon.etl.setter;

import de.moscon.etl.beans.Customer;
import de.moscon.etl.beans.Sale;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaleItemPreparedStmSetter implements ItemPreparedStatementSetter<Sale> {

    @Override
    public void setValues(Sale sale, PreparedStatement ps) throws SQLException {
//        ps.setLong(1, sale.getId());
        ps.setLong(1, sale.getProductId());
        ps.setLong (2, sale.getCustomerId());
        ps.setInt(3, sale.getCount());
        ps.setString(4, sale.getNetPriceSumFormatted());
        ps.setString(5, sale.getTimeFormatted());
    }
}
