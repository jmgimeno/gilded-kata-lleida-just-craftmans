package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    void incrementQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }

    void updateQuality() {
        preAdjustQuality();
        adjustSellIn();
        postAdjustQuality();
    }

    private void postAdjustQuality() {
        if (sellIn < 0) {
            if (name.equals("Aged Brie")) {
                incrementQuality();
            } else {
                if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    quality = quality - quality;
                } else {
                    if (quality > 0) {
                        if (name.equals("Sulfuras, Hand of Ragnaros")) {
                            return;
                        }
                        quality = quality - 1;
                    }
                }
            }
        }
    }

    private void adjustSellIn() {
        if (name.equals("Sulfuras, Hand of Ragnaros")) {
        } else {
            sellIn = sellIn - 1;
        }
    }

    private void preAdjustQuality() {
        if (name.equals("Aged Brie")
                || name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (quality < 50) {
                quality = quality + 1;

                if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (sellIn < 11) {
                        incrementQuality();
                    }

                    if (sellIn < 6) {
                        incrementQuality();
                    }
                }
            }
        } else {
            if (quality > 0) {
                if (name.equals("Sulfuras, Hand of Ragnaros")) {
                } else {
                    quality = quality - 1;
                }
            }
        }
    }
}
