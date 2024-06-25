package com.gildedrose;

public class ConjuredItemUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        if (item.quality > 0) {
            item.quality -= 2;
        }

        item.sellIn--;

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality -= 2;
        }
    }
}
