import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class GildedRoseTest {

    // ------------------------------------- normal -------------------------------------------------------------------
    @Test
    public void testNormalItemBeforeSellDate() {
        GildedRose item = new GildedRose("normal", 10, 5);
        item.tick();

        assertEquals(9, item.quality);
        assertEquals(4, item.daysRemaining);
    }

    @Test
    public void testNormalItemOnSellDate() {
        GildedRose item = new GildedRose("normal", 10, 0);
        item.tick();

        assertEquals(8, item.quality);
        assertEquals(-1, item.daysRemaining);
    }

    @Test
    public void testNormalItemAfterSellDate() {
        GildedRose item = new GildedRose("normal", 10, -1);
        item.tick();

        assertEquals(8, item.quality);
        assertEquals(-2, item.daysRemaining);
    }

    @Test
    public void testNormalItemOfZeroQuality() {
        GildedRose item = new GildedRose("normal", 0, 5);
        item.tick();

        assertEquals(0, item.quality);
        assertEquals(4, item.daysRemaining);
    }

    // ------------------------------------- brie ---------------------------------------------------------------------
    // quality is getting increased by 1 , if daysrem >0
    @Test
    public void testBrieBeforeSellDate() {
        GildedRose item = new GildedRose("Aged Brie", 10, 5);
        item.tick();

        assertEquals(11, item.quality);
        assertEquals(4, item.daysRemaining);
    }

    // max qualtiy can be 50 
    @Test
    public void testBrieBeforeSellDateWithMaxQuality() {
        GildedRose item = new GildedRose("Aged Brie", 50, 5);
        item.tick();

        assertEquals(50, item.quality);
        assertEquals(4, item.daysRemaining);
    }

    // on sale day the brie quality is getting increased by 2
    @Test
    public void testBrieOnSellDate() {
        GildedRose item = new GildedRose("Aged Brie", 10, 0);
        item.tick();

        assertEquals(12, item.quality);
        assertEquals(-1, item.daysRemaining);
    }
    // if quality is near to max(49) and its the sell day the brie quality is getting incrased to max(50) 
    @Test
    public void testBrieOnSellDateNearMaxQuality() {
        GildedRose item = new GildedRose("Aged Brie", 49, 0);
        item.tick();

        assertEquals(50, item.quality);
        assertEquals(-1, item.daysRemaining);
    }

    //(repeated) on the saleday the max quality (50) will remain unchanged

    @Test
    public void testBrieOnSellDateWithMaxQuality() {
        GildedRose item = new GildedRose("Aged Brie", 50, 0);
        item.tick();

        assertEquals(50, item.quality);
        assertEquals(-1, item.daysRemaining);
    }

    //(repeated)after the sell day brie quality is getting increased by 2

    @Test
    public void testBrieAfterSellDate() {
        GildedRose item = new GildedRose("Aged Brie", 10, -1);
        item.tick();

        assertEquals(12, item.quality);
        assertEquals(-2, item.daysRemaining);
    }

    // a brie with quality max (50) will have the same quality after the sellday

    @Test
    public void testBrieAfterSellDateWithMaxQuality() {
        GildedRose item = new GildedRose("Aged Brie", 50, -1);
        item.tick();

        assertEquals(50, item.quality);
        assertEquals(-2, item.daysRemaining);
    }

    // ------------------------------------- sulfuras -----------------------------------------------------------------
    @Test
    public void testSulfurasBeforeSellDate() {
        GildedRose item = new GildedRose("Sulfuras, Hand of Ragnaros", 10, 5);
        item.tick();

        assertEquals(10, item.quality);
        assertEquals(5, item.daysRemaining);
    }

    @Test
    public void testSulfurasOnSellDate() {
        GildedRose item = new GildedRose("Sulfuras, Hand of Ragnaros", 10, 0);
        item.tick();

        assertEquals(10, item.quality);
        assertEquals(0, item.daysRemaining);
    }

    @Test
    public void testSulfurasAfterSellDate() {
        GildedRose item = new GildedRose("Sulfuras, Hand of Ragnaros", 10, -1);
        item.tick();

        assertEquals(10, item.quality);
        assertEquals(-1, item.daysRemaining);
    }

    // ------------------------------------- sulfuras -----------------------------------------------------------------
    @Test
    public void testBackStagePassLongBeforeSellDate() {
        GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 10, 30);
        item.tick();

        assertEquals(11, item.quality);
        assertEquals(29, item.daysRemaining);
    }

    // medium close to saledate  upperbound is 10
    @Test
    public void testBackstagePassMediumCloseToSellDateUpperBound() {
        GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 10, 10);
        item.tick();

        assertEquals(12, item.quality);
        assertEquals(9, item.daysRemaining);
    }


    @Test
    public void testBackstagePassMediumCloseToSellDateUpperBoundAtMaxQuality() {
        GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 50, 10);
        item.tick();

        assertEquals(50, item.quality);
        assertEquals(9, item.daysRemaining);
    }

    //medium close to saledate  lowerbound is 6

    @Test
    public void testBackstagePassMediumCloseToSellDateLowerBound() {
        GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 10, 6);
        item.tick();

        assertEquals(12, item.quality);
        assertEquals(5, item.daysRemaining);
    }

    @Test
    public void testBackstagePassMediumCloseToSellDateLowerBoundAtMaxQuality() {
        GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 50, 6);
        item.tick();

        assertEquals(50, item.quality);
        assertEquals(5, item.daysRemaining);
    }

    //very close to sale date upper bound is 5      // quality += 3
    @Test
    public void testBackstagePassVeryCloseToSellDateUpperBound() {
        GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 10, 5);
        item.tick();

        assertEquals(13, item.quality);
        assertEquals(4, item.daysRemaining);
    }

    //
    @Test
    public void testBackstagePassVeryCloseToSellDateUpperBoundAtMaxQuality() {
        GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 50, 5);
        item.tick();

        assertEquals(50, item.quality);
        assertEquals(4, item.daysRemaining);
    }

    //very close to sale date lower bound is 1     // quality += 3
    @Test
    public void testBackstagePassVeryCloseToSellDateLowerBound() {
        GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 10, 1);
        item.tick();

        assertEquals(13, item.quality);
        assertEquals(0, item.daysRemaining);
    }

    @Test
    public void testBackstagePassVeryCloseToSellDateLowerBoundAtMaxQuality() {
        GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 50, 1);
        item.tick();

        assertEquals(50, item.quality);
        assertEquals(0, item.daysRemaining);
    }

    //daysrem =0
    @Test
    public void testBackStagePassOnSellDate() {
        GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 10, 0);
        item.tick();

        assertEquals(0, item.quality);
        assertEquals(-1, item.daysRemaining);
    }

    @Test
    public void testBackStagePassAfterSellDate() {
        GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 10, -1);
        item.tick();

        assertEquals(0, item.quality);
        assertEquals(-2, item.daysRemaining);
    }

    @Test
    @Ignore
    public void testConjuredItemBeforeSellDate() {
        GildedRose item = new GildedRose("Conjured Item", 10, 5);
        item.tick();

        assertEquals(8, item.quality);
        assertEquals(4, item.daysRemaining);
    }

    @Test
    @Ignore
    public void testConjuredItemAtZeroQuality() {
        GildedRose item = new GildedRose("Conjured Item", 1, 1);
        item.tick();

        assertEquals(0, item.quality);
        assertEquals(0,item.daysRemaining);
    }

    @Test
    @Ignore
    public void testConjuredItemOnSellDate() {
        GildedRose item = new GildedRose("Conjured Item", 10, 0);
        item.tick();

        assertEquals(6, item.quality);
        assertEquals(-1, item.daysRemaining);
    }

    @Test
    @Ignore
    public void testConjuredItemOnSellDateAtZeroQuality() {
        GildedRose item = new GildedRose("Conjured Item", 0, 0);
        item.tick();

        assertEquals(0, item.quality);
        assertEquals(-1, item.daysRemaining);
    }

    @Test
    @Ignore
    public void testConjuredItemAfterSellDate() {
        GildedRose item = new GildedRose("Conjured Item", 10, -1);
        item.tick();

        assertEquals(6, item.quality);
        assertEquals(-2, item.daysRemaining);
    }

    @Test
    @Ignore
    public void testConjuredItemAfterSellDateAtZeroQuality() {
        GildedRose item = new GildedRose("Conjured Item", 0, -1);
        item.tick();

        assertEquals(0, item.quality);
        assertEquals(-2, item.daysRemaining);
    }

}

