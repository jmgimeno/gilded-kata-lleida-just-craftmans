package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public static QualityUpdater clasify(Item item) {
        if (item.name.equals("Aged Brie"))
            return new BrieUpdater(item);
        else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert"))
            return new PassUpdater(item);
        else
            return new QualityUpdater(item);
    }

    public void updateQuality() {
        for (Item item : items) {
            QualityUpdater updater = clasify(item);
            updater.updateQualityOfItem();
        }
    }

    public static class QualityUpdater {

        protected final Item item;

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

        protected void adjustQualityForExpiredItems() {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                if (item.quality > 0) {
                    return;
                }
                item.quality = item.quality - 1;
            } else if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }

        protected void updateSellIn() {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            } else {
                item.sellIn = item.sellIn - 1;
            }
        }

        protected void adjustQuality() {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                if (item.quality > 0) {
                } else {
                    item.quality = item.quality - 1;
                }
            } else if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }

        protected void incrementQuality() {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }


    private static class BrieUpdater extends QualityUpdater {
        public BrieUpdater(Item item) {
            super(item);
        }

        protected void adjustQualityForExpiredItems() {
            incrementQuality();
        }

        protected void updateSellIn() {
            item.sellIn = item.sellIn - 1;
        }

        protected void adjustQuality() {
            incrementQuality();
        }
    }

    private static class PassUpdater extends QualityUpdater {
        public PassUpdater(Item item) {
            super(item);
        }

        protected void adjustQualityForExpiredItems() {
            item.quality = 0;

        }

        protected void updateSellIn() {
            item.sellIn = item.sellIn - 1;
        }

        protected void adjustQuality() {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.sellIn < 11) {
                    incrementQuality();
                }

                if (item.sellIn < 6) {
                    incrementQuality();
                }
            }
        }
    }
}