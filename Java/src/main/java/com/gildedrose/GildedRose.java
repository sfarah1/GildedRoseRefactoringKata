package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

class GildedRose {
    Item[] items;

    private final Map<String, ItemUpdater> updaterMap = new HashMap<>();

    public GildedRose(Item[] items) {
        this.items = items;
        updaterMap.put("Aged Brie", new AgedBrieUpdater());
        updaterMap.put("Sulfuras, Hand of Ragnaros", new SulfurasUpdater());
        updaterMap.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassUpdater());
        updaterMap.put("Conjured Mana Cake", new ConjuredItemUpdater());
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdater updater = getUpdater(item);
            updater.update(item);
        }
    }

    private ItemUpdater getUpdater(Item item) {
        return updaterMap.getOrDefault(item.getName(), new NormalItemUpdater());
    }
}
