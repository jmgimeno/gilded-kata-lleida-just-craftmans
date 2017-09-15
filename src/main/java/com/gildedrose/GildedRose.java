package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            QualityUpdater updater = QualityUpdater.clasify(item);
            updater.updateQualityOfItem(item);
        }
    }

}