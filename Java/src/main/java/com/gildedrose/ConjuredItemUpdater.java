package com.gildedrose;

public class ConjuredItemUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        item.setSellIn(item.getSellIn() - 1);

        if (item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 2);
        }

        if (item.getSellIn() < 0 && item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 2);
        }

        if (item.getQuality() < 0) {
            item.setQuality(0);
        }
    }
}
