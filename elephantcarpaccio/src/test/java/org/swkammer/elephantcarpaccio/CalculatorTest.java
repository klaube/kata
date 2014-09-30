package org.swkammer.elephantcarpaccio;

import java.math.BigDecimal;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Armin H., Katharina L.
 */
@RunWith(JUnitParamsRunner.class)
public class CalculatorTest {

    @Test
    @Parameters({
            "1, 1.19, DE",
            "3, 3.57, DE",
            "1, 1.25, DK",
            "3, 3.75, DK",
            "1, 1.25, HR",
            "1, 1.26, IS",
            "1, 1.08, CH"
    })
    public void givenCountryAndAmountWhenNoDiscountShouldReturnPriceWithTax(int amount, String totalPrice, String countryCode) {
        final Calculator calculator = new Calculator(amount, "1.00", countryCode);
        Assert.assertThat(calculator.getTotalPrice(), CoreMatchers.is(new BigDecimal(totalPrice)));
    }

    @Test
    @Parameters({
            "1001, 970.97",
            "5001, 4750.95",
            "7001, 6510.93",
            "10001, 9000.90",
            "50001, 42500.85",
    })
    public void givenPriceBetween1000And4999ShouldDiscount3Percentage(int amount, String totalPrice) {
        final Calculator calculator = new Calculator(amount, "1.00", "DE");
        Assert.assertThat(calculator.getDiscountResult(), CoreMatchers.is(new BigDecimal(totalPrice)));
    }

    @Test
    @Parameters({
            "1, 1001.00, 1155.45",
            "1001, 1, 1155.45"
    })
    public void givenPriceAmountAndCountryShouldReturnTotalPrice(int amount, String singlePrice, String totalPrice) {
        final Calculator calculator = new Calculator(amount, singlePrice, "DE");
        Assert.assertThat(calculator.getTotalPrice(), CoreMatchers.is(new BigDecimal(totalPrice)));
    }
}
