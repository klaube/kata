package org.swkammer.elephantcarpaccio;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

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
    public void testOneItemForOneEuroInDeCosts119(int itemNumber, String totalPrice, String countryCode) {
        final Calculator calculator = new Calculator(itemNumber, "1.00", countryCode);
        Assert.assertThat(calculator.getTaxResult(), CoreMatchers.is(new BigDecimal(totalPrice)));
    }

    @Test
    @Parameters({
            "1000, 970.00",
            "2000, 1940.00"
    })
    public void testOneItemFor1000EuroInDeCosts(int itemNumber, String totalPrice) {
        final Calculator calculator = new Calculator(itemNumber, "1.00", "DE");
        Assert.assertThat(calculator.getDiscountResult(), CoreMatchers.is(new BigDecimal(totalPrice)));
    }

    @Ignore
    @Test
    @Parameters({
            "1000, 970.00"
    })
    public void testOneItemFor1000EuroInDeCost(int itemNumber, String totalPrice) {
        final Calculator calculator = new Calculator(itemNumber, "1.00", "DE");
        Assert.assertThat(calculator.getTotalPrice(), CoreMatchers.is(new BigDecimal(totalPrice)));
    }
}
