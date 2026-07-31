public class DogWithFeat extends Dog{
    private String breed;
    
    public DogWithFeat(){
        this.breed = "";
    }

    public DogWithFeat(String breed){
        this.breed = breed;
    }

    public String describe(){
        return "This dog is a " + (!this.breed.isEmpty()? this.breed: "unknown breed");
    }

}
