public class Backstage extends GildedRose {

    public Backstage(String name, int quality, int daysRemaining) {
        super(name, quality, daysRemaining);
    }
    
    public void tick(){

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
