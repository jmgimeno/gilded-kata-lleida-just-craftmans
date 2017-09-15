package com.gildedrose;

class GildedRose {
    Item[] items;
    private static String STATE1 = "Backstage passes to a TAFKAL80ETC concert";
    private static String STATE_SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static String AGED_BRIE = "Aged Brie";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {

            Item item = items[i];
            String name = item.name;


            if (!name.equals(AGED_BRIE) && !name.equals(STATE1)) {
                if (item.quality > 0) {
                    if (!name.equals(STATE_SULFURAS)) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (name.equals(STATE1)) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!name.equals(STATE_SULFURAS)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!name.equals(AGED_BRIE)) {
                    if (!name.equals(STATE1)) {
                        if (item.quality > 0) {
                            if (!name.equals(STATE_SULFURAS)) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }

        }
    }
}