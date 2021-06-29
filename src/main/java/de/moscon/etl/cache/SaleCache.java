package de.moscon.etl.cache;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;

@Component
public class SaleCache {

    static private HashMap<Long, Date> saleCache = new HashMap<>();

    public SaleCache() {
    }

    public void addToSaleCache(Long id, Date minOrderDate) {
        saleCache.put(id, minOrderDate);
    }

    public Date getMinOrderDate(Long id) {
        return saleCache.get(id);
    }

    public Integer getSize() {
        return saleCache.size();
    }
}
