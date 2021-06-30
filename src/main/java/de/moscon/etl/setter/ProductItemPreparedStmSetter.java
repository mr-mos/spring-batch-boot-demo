package de.moscon.etl.setter;

import de.moscon.etl.beans.Customer;
import de.moscon.etl.beans.Product;
import de.moscon.etl.utils.DecimalUtils;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class ProductItemPreparedStmSetter implements ItemPreparedStatementSetter<Product> {

    DecimalUtils du = new DecimalUtils();

    @Override
    public void setValues(Product product, PreparedStatement ps) throws SQLException {
//        ps.setLong(1, product.getId());
        ps.setString(1, product.getDisplayName());
        ps.setDouble (2, du.newDouble(product.getNetPriceFormatted()));
        ps.setString(3, product.getCategory());
        ps.setString(4, product.getPlayerBrand());
    }

}
