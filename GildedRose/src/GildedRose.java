

class GildedRose {

	public GildedRose() {
	}

	public void handleItems(Item[] items) {
		for (int i = 0; i < items.length; i++) {
			Item item = items[i];
			handleItem(item);
		}
	}

	void handleItem(Item item) {
		if (isLegendary(item)) {
			return;
		}
		
		if (item.name.equals("Craftspeople Potion")) {
			increaseQuality(item);
			return;
		}
		
		if (isCheese(item)) {
			handleCheese(item);
			return;
		} 
		
		if (isTicket(item)) {
			handleTicket(item);
			return;
		}
		
		if(isConjured(item)) {
			handleConjured(item);
			return;
		}

		decreaseQuality(item);
		decreaseSellIn(item);

		if (item.sellIn < 0) {
			decreaseQuality(item);
		}
	}
	
	private void handleCheese(Item item) {
		increaseQuality(item);
		
		decreaseSellIn(item);
		
		if (item.sellIn < 0) {
			increaseQuality(item);
		}
	}

	private void handleTicket(Item item) {
		increaseQuality(item);

		if (item.sellIn < 11) {
			increaseQuality(item);
		}

		if (item.sellIn < 6) {
			increaseQuality(item);
		}

		decreaseSellIn(item);

		if (item.sellIn < 0) {
			item.quality = 0;
		}
	}
	
	private void handleConjured(Item item) {
		decreaseQuality(item);
		decreaseQuality(item);
		
		decreaseSellIn(item);
		
		if (item.sellIn < 0) {
			decreaseQuality(item);
			decreaseQuality(item);
		}
	}

	private boolean isCheese(Item item) {
		return item.name.equals("Aged Brie");
	}

	private boolean isTicket(Item item) {
		return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
	}

	private boolean isLegendary(Item item) {
		return item.name.equals("Sulfuras, Hand of Ragnaros");
	}
	
	private boolean isConjured(Item item) {
		return item.name.equals("conjured item");
	}

	private void decreaseSellIn(Item item) {
		item.sellIn = item.sellIn - 1;
	}

	private void decreaseQuality(Item item) {
		if (item.quality > 0) {
			item.quality = item.quality - 1;
		}
	}

	private void increaseQuality(Item item) {
		if (item.quality < 50) {
			item.quality = item.quality + 1;
		}
	}
}
