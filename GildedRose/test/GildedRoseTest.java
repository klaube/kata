import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class GildedRoseTest {

    @Test
    @Parameters({
    	"+5 Dexterity Vest, 10, 9",
    	"+5 Dexterity Vest, 1, 0",
    	"Elixir of the Mongoose, 0, -1",
    	"Elixir of the Mongoose, -1, -2",
    	"Aged Brie, 0, -1",
    	"Aged Brie, -1, -2",
    	"Backstage passes to a TAFKAL80ETC concert, 1, 0",
    	"Backstage passes to a TAFKAL80ETC concert, -1, -2",
    })
    public void sellInShouldDecreaseByOne(String name, int sellIn, int newSellin) {
        runTestSellIn(name, sellIn, newSellin);
    }
    
    @Test
    @Parameters({
    	"Sulfuras\\, Hand of Ragnaros, 1, 1",
    	"Sulfuras\\, Hand of Ragnaros, 0, 0"
    })
    public void sellInOfLegendaryItemShouldNotDecrease(String name, int sellIn, int newSellin) {
    	runTestSellIn(name, sellIn, newSellin);
    }

	private void runTestSellIn(String name, int sellIn, int newSellin) {
		Item[] items = new Item[] { new Item(name, sellIn, 20) };
        GildedRose app = new GildedRose(items);
        
        // act
        app.handleItems();
        
        // check
        Item item = app.items[0];
		assertEquals(newSellin, item.sellIn);
	}

    @Test
    @Parameters({
    	"+5 Dexterity Vest, 10, 20, 19",
    	"+5 Dexterity Vest, 1, 20, 19",
    	"Elixir of the Mongoose, 5, 7, 6"
    })
    public void qualityShouldDecreaseByOneBeforeSellDate(String name, int sellIn, int quality, int newQuality) {
        runTestQuality(name, sellIn, quality, newQuality);
    }

    @Parameters({
    	"+5 Dexterity Vest, 0, 20, 18",
    	"Elixir of the Mongoose, 0, 10, 8"
    })
    @Test
    public void qualityShouldDecreaseByTwoAfterSellDate(String name, int sellIn, int quality, int newQuality) {
        runTestQuality(name, sellIn, quality, newQuality);
    }
    
    @Test
    @Parameters({
    	"+5 Dexterity Vest, 10, 0, 0",
    	"+5 Dexterity Vest, 0, 1, 0",
    	"Elixir of the Mongoose, 5, -1, -1",
    	"conjured item, 0, 0, 0"
    })
    public void qualityShouldNeverBecomeNegative(String name, int sellIn, int quality, int newQuality) {
    	runTestQuality(name, sellIn, quality, newQuality);
    }
    
    @Parameters({
    	"conjured item, 10, 20, 18",
    	"conjured item, 0, 20, 16"
    })
    @Test
    public void qualityOfConjuredItemsShouldDecreaseTwice(String name, int sellIn, int quality, int newQuality) {
    	runTestQuality(name, sellIn, quality, newQuality);
    }
    
    @Test
    @Parameters({
    	"Aged Brie, 2, 49, 50",
    })
    public void qualityOfAgedBrieShouldIncrease(String name, int sellIn, int quality, int newQuality) {
    	runTestQuality(name, sellIn, quality, newQuality);
    }
    
    @Test
    @Parameters({
    	"Backstage passes to a TAFKAL80ETC concert, 15, 50, 50",
    	"Backstage passes to a TAFKAL80ETC concert, 15, 10, 11",
    	"Backstage passes to a TAFKAL80ETC concert, 10, 10, 12",
    	"Backstage passes to a TAFKAL80ETC concert, 5, 10, 13",
    	"Backstage passes to a TAFKAL80ETC concert, 0, 10, 0",
    })
    public void qualityOfTicketsShouldIncrease(String name, int sellIn, int quality, int newQuality) {
    	runTestQuality(name, sellIn, quality, newQuality);
    }
    
    @Test
    @Parameters({
    	"Aged Brie, 2, 50, 50",
    	"Backstage passes to a TAFKAL80ETC concert, 2, 50, 50",
    })
    public void qualityOfAnItemShouldBeAtMaximum50(String name, int sellIn, int quality, int newQuality) {
    	runTestQuality(name, sellIn, quality, newQuality);
    }
    
    @Test
    @Parameters({
    	"Sulfuras\\, Hand of Ragnaros, 30, 80, 80",
    	"Sulfuras\\, Hand of Ragnaros, 10, 80, 80",
    	"Sulfuras\\, Hand of Ragnaros, 5, 80, 80",
    	"Sulfuras\\, Hand of Ragnaros, -1, 80, 80"
    })
    public void qualityOfLegendaryItemShouldNotDecrease(String name, int sellIn, int quality, int newQuality) {
    	runTestQuality(name, sellIn, quality, newQuality);
    }

	private void runTestQuality(String name, int sellIn, int quality, int newQuality) {
		Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        
        // act
        app.handleItems();
        
        // check
        Item item = app.items[0];
		assertEquals(newQuality, item.quality);
	}

}
