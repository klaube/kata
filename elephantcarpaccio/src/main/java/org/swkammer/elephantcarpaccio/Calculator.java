package org.swkammer.elephantcarpaccio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/**
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

    public BigDecimal getTaxResult() {
        return TAX.get(countryCode).multiply(amount).multiply(price).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    public BigDecimal getTaxResult(BigDecimal priceBeforeTax) {
        return TAX.get(countryCode).multiply(amount).multiply(priceBeforeTax).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getDiscountResult() {
        final BigDecimal discount = BigDecimal.ONE.subtract(new BigDecimal("0.03"));
        BigDecimal result = price.multiply(discount).multiply(amount);
        return result.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTotalPrice() {
        return getTaxResult(getDiscountResult());
    }
}
