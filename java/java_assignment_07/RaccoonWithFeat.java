public class RaccoonWithFeat extends Raccoon{
    private boolean isPet;

    public RaccoonWithFeat(){
        this.isPet = false;
    }

    public RaccoonWithFeat(boolean isPet){
        this.isPet = isPet;
    }

    public String describe(){
        return "This raccoon is" + (isPet? "a pet":"not a pet");
    }

}
