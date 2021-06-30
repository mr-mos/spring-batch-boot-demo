package de.moscon.etl.setter;

import de.moscon.etl.beans.Customer;
import de.moscon.etl.beans.Product;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductItemPreparedStmSetter implements ItemPreparedStatementSetter<Product> {

    @Override
    public void setValues(Product product, PreparedStatement ps) throws SQLException {
//        ps.setLong(1, product.getId());
        ps.setString(1, product.getDisplayName());
        ps.setString (2, product.getNetPriceFormatted());
        ps.setString(3, product.getCategory());
        ps.setString(4, product.getPlayerBrand());
    }

}
