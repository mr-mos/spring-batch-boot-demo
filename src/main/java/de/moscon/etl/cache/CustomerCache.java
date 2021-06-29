package de.moscon.etl.cache;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
@Component
public class CustomerCache {

    static private HashMap<Long, Date> customerCache = new HashMap<>();

    public CustomerCache() {
    }

    public void addToCustomerCache(Long id, Date registrationDate) {
        customerCache.put(id, registrationDate);
    }

    public Date getRegistrationDate(Long id) {
        return customerCache.get(id);
    }

    public Integer getSize() {
        return customerCache.size();
    }

 }


