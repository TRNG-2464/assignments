package HomeTour;

public class Entity {
    private String name;
    private String description;
    private String interaction;

    public Entity(String name, String description, String interaction){
        this.name = name;
        this.description=description;
        this.interaction=interaction;
    }

    public String getEntityName(){
        return name;
    }

    public String getEntityDescription(){
        return description;
    }

    public String interactWithEntity(){
        return interaction;
    }

}
