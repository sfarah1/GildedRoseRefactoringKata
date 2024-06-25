package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdater updater = getItemUpdater(item);
            updater.update(item);
        }
    }

    private ItemUpdater getItemUpdater(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new AgedBrieUpdater();
            case "Sulfuras, Hand of Ragnaros":
                return new SulfurasUpdater();
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePassUpdater();
            case "Conjured Mana Cake":
                return new ConjuredItemUpdater();
            default:
                return new NormalItemUpdater();
        }
    }
}
