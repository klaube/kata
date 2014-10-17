package org.swkammer.elephantcarpaccio;

import java.math.BigDecimal;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Each test represents one slice where one test is one call with different test parameters.
 * 
 * @author Armin H., Katharina L.
 */
@RunWith(JUnitParamsRunner.class)
public class CalculatorTest {

    @Test
    @Parameters({
            "1, DE, 1.19",
            "3, DE, 3.57",
            "1, DK, 1.25",
            "3, DK, 3.75",
            "1, HR, 1.25",
            "1, IS, 1.26",
            "1, CH, 1.08"
    })
    public void givenCountryAndPriceWhenNoDiscountShouldReturnPriceWithTax(String price, String countryCode, String priceWithTax) {
        final Calculator calculator = new Calculator(1, price, countryCode);
        Assert.assertThat(calculator.getTotalPrice(), CoreMatchers.is(new BigDecimal(priceWithTax)));
    }

    @Test
    @Parameters({
            "1001, 970.97",
            "5001, 4750.95",
            "7001, 6510.93",
            "10001, 9000.90",
            "50001, 42500.85"
    })
    public void givenPriceAbove1000ShouldLeadToDiscount(String price, String priceWithDiscount) {
        final Calculator calculator = new Calculator(1, price, "DE");
        Assert.assertThat(calculator.getDiscountResult(), CoreMatchers.is(new BigDecimal(priceWithDiscount)));
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
