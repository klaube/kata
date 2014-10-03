package org.swkammer.elephantcarpaccio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/**
 * This class calculates the total price with discount and tax,
 * when the amount of items, single price and country code is given.
 * 
 * @author Armin H., Katharina L.
 */
public class Calculator {

	private static final Map<String, BigDecimal> TAX = new HashMap<String, BigDecimal>();
    static {
        TAX.put("DE", new BigDecimal("1.19"));
        TAX.put("DK", new BigDecimal("1.25"));
        TAX.put("HR", new BigDecimal("1.25"));
        TAX.put("IS", new BigDecimal("1.255"));
        TAX.put("CH", new BigDecimal("1.08"));
    }

    private final BigDecimal amount;
    private final BigDecimal price;
    private final String countryCode;

    public Calculator(int amount, String price, String countryCode) {
        this.amount = new BigDecimal(amount);
        this.price = new BigDecimal(price);
        this.countryCode = countryCode;
    }

    public BigDecimal getTotalPrice() {
        return getTaxResult(getDiscountResult());
    }

    BigDecimal getTaxResult(BigDecimal priceBeforeTax) {
        return TAX.get(countryCode).multiply(priceBeforeTax).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    BigDecimal getDiscountResult() {
        final BigDecimal orderValue = price.multiply(amount);
		final double orderValueDouble = orderValue.doubleValue();
		
		BigDecimal discount = new BigDecimal("1.00");
		if (orderValueDouble > 50000) {
        	discount = discount.subtract(new BigDecimal("0.15"));
        } 
        else if (orderValueDouble > 10000) {
        	discount = discount.subtract(new BigDecimal("0.10"));  	
        } 
        else if (orderValueDouble > 7000) {
        	discount = discount.subtract(new BigDecimal("0.07"));     	
        } 
        else if (orderValueDouble > 5000) {
        	discount = discount.subtract(new BigDecimal("0.05"));     	
        } 
        else if (orderValueDouble > 1000) {
        	discount = discount.subtract(new BigDecimal("0.03"));     	
        }
		return orderValue.multiply(discount).setScale(2, RoundingMode.HALF_UP);
    }
}
