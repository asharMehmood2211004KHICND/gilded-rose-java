public class Brie extends Normal{

    public Brie(String name, int quality, int daysRemaining) {
        super(name, quality, daysRemaining);
        //TODO Auto-generated constructor stub
    }


    public void tick(){



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


}
