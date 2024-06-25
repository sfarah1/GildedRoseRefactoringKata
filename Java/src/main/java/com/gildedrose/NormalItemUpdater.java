package com.gildedrose;

public class NormalItemUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        item.setSellIn(item.getSellIn() - 1);

        if (item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 1);
        }

        if (item.getSellIn() < 0 && item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 1);
        }
    }
}
