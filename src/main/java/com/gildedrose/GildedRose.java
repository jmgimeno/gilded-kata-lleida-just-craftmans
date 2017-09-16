package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public static QualityUpdater clasify(Item item) {
        return new QualityUpdater(item);
    }

    public void updateQuality() {
        for (Item item : items) {
            QualityUpdater updater = clasify(item);
            updater.updateQualityOfItem();
        }
    }

    public static class QualityUpdater {

        private final Item item;

        public QualityUpdater(Item item) {
            this.item = item;
        }

        void updateQualityOfItem() {
            adjustQuality();

            updateSellIn();

            if (itemHasExpired()) {
                adjustQualityForExpiredItems();
            }
        }

        private boolean itemHasExpired() {
            return item.sellIn < 0;
        }

        private void adjustQualityForExpiredItems() {
            if (item.name.equals("Aged Brie")) {
                incrementQuality();
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                item.quality = item.quality - item.quality;
            } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                if (item.quality > 0) {
                    return;
                }
                item.quality = item.quality - 1;
            } else if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }

        private void updateSellIn() {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            } else {
                item.sellIn = item.sellIn - 1;
            }
        }

        private void adjustQuality() {
            if (item.name.equals("Aged Brie")) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.sellIn < 11) {
                        incrementQuality();
                    }

                    if (item.sellIn < 6) {
                        incrementQuality();
                    }
                }
            } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                if (item.quality > 0) {
                } else {
                    item.quality = item.quality - 1;
                }
            } else if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }

        private void incrementQuality() {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }
}