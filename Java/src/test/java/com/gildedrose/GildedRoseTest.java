package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

//    @Test
//    void foo() {
//        Item[] items = new Item[]{new Item("foo", 0, 0)};
//        GildedRose app = new GildedRose(items);
//        app.updateQuality();
//        assertEquals("fixme", app.items[0].name);
//    }


    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name); // This should pass if updateQuality doesn't change the name
    }

}
