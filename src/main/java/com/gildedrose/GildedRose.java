package com.gildedrose;

class GildedRose {
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            QualityUpdater updater = clasify(item);
            updater.updateQualityOfItem();
        }
    }

    private static QualityUpdater clasify(Item item) {
        if (item.name.equals("Aged Brie"))
            return new BrieUpdater(item);
        else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert"))
            return new PassUpdater(item);
        else if (item.name.equals("Sulfuras, Hand of Ragnaros"))
            return new SulfurasUpdater(item);
        else
            return new QualityUpdater(item);
    }

    private static class QualityUpdater {

        final Item item;

        QualityUpdater(Item item) {
            this.item = item;
        }

        void updateQualityOfItem() {
            adjustQuality();

            updateSellIn();

            if (itemHasExpired()) {
                adjustQualityForExpiredItems();
            }
        }

        protected void adjustQualityForExpiredItems() {
            decrementQuality();
        }

        protected void updateSellIn() {
            item.sellIn = item.sellIn - 1;
        }

        protected void adjustQuality() {
            decrementQuality();
        }

        private boolean itemHasExpired() {
            return item.sellIn < 0;
        }

        protected void incrementQuality() {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }

        private void decrementQuality() {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }


    private static class BrieUpdater extends QualityUpdater {
        BrieUpdater(Item item) {
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
        PassUpdater(Item item) {
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

    private static class SulfurasUpdater extends QualityUpdater {
        SulfurasUpdater(Item item) {
            super(item);
        }

        protected void adjustQualityForExpiredItems() {

        }

        protected void updateSellIn() {

        }

        protected void adjustQuality() {

        }
    }
}
