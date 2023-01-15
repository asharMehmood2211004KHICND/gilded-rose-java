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


           normal_tick();
        }

        if(name.equals("Aged Brie")){


            Aged_Brie_tick();
         }

        if(name.equals("Backstage passes to a TAFKAL80ETC concert")){
            back_stage_tick();
        }

    }

    public void normal_tick(){
        daysRemaining-=1;
        if(quality!=0){
            if(daysRemaining<=0){
                quality-=1;
            }
            quality-=1;
        }

    }

    public void Aged_Brie_tick(){



        // before the sale day
        if(daysRemaining>0){
//            daysRemaining-=1;
            if(quality!=50){
                quality+=1;
            }

        }

            if(daysRemaining==0){

                if(quality!=50){
                    if(quality!=49){
                        quality+=2;
                    }
                    else {
                        quality=50;
                    }
                }
            }


           if(daysRemaining<0) {
               if (quality != 50) {
                   quality += 2;
               }
           }
        daysRemaining-=1;

    }

    public void back_stage_tick(){

            if(quality!=50){
                if(daysRemaining>=30){
                    quality+=1;
                }
                else if(daysRemaining>=10 || daysRemaining >=6 ){
                    quality+=2;
                }
                else if(daysRemaining<=5 && daysRemaining >0){
                    quality+=3;
                }

                else if(daysRemaining<=0){
                    quality=0;
                }


            }



            daysRemaining-=1;

    }

}
