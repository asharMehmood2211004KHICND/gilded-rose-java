public class Normal extends GildedRose{
    

    public Normal(String name, int quality, int daysRemaining) {
        super(name, quality, daysRemaining);
        //TODO Auto-generated constructor stub
    }

    public void tick(){
        daysRemaining-=1;
        if(quality!=0){
            if(daysRemaining<=0){
                quality-=1;
            }
            quality-=1;
        }

    }

}
