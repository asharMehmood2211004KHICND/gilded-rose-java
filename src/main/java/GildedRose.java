import org.apache.commons.lang3.StringUtils;

public class GildedRose {

    public String name;
    public int quality;
    public int daysRemaining;

    public GildedRose(String name, int quality, int daysRemaining) {
        this.name = name;
        this.quality = quality;
        this.daysRemaining = daysRemaining;
    }

    public void tick() {

        if(name.equals("normal")){
            Normal normal = new Normal(name, quality, daysRemaining);
            normal.tick();
            this.quality=normal.quality;
            this.daysRemaining=normal.daysRemaining;

        }

        if(name.equals("Aged Brie")){
            
            Brie brie = new Brie(name, quality, daysRemaining);
            brie.tick();
            this.quality=brie.quality;
            this.daysRemaining=brie.daysRemaining;
         }

        if(name.equals("Backstage passes to a TAFKAL80ETC concert")){
            //back_stage_tick();
            Backstage backstage = new Backstage(name, quality, daysRemaining);
            backstage.tick();
            this.quality=backstage.quality;
            this.daysRemaining=backstage.daysRemaining;
        }

        if(name.equals("Conjured Item")){
            Conjured conjured = new Conjured(name, quality, daysRemaining);
            conjured.tick();
            this.quality=conjured.quality;
            this.daysRemaining=conjured.daysRemaining;
        }

    }

}
