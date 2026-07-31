public class BirdWithFeat extends Bird{

    
    private boolean canNest;
    public BirdWithFeat(){
        this.canNest = true;
    }

    public BirdWithFeat(boolean canNest){
        this.canNest = canNest;
    }
    @Override
    public String describe(){
        return "This winged animal with two feet " + (canNest? "can make a nest": "cannot make a nest");
        
    }

}
