import javax.xml.namespace.QName;

public class Conjured extends GildedRose {

    public Conjured(String name, int quality, int daysRemaining) {
        super(name, quality, daysRemaining);
    }
    
    public void tick(){
        if(quality!=0){
            // quality -=1;
            if(daysRemaining>1){
                quality-=2;

            }
            else if(daysRemaining==1){
                quality-=1;
            }

            else if(daysRemaining<=0){
                quality-=4;
            }
        }

        

        daysRemaining-=1;
    }
}
