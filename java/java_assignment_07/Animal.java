abstract class Animal { // is-a: captures identify and state
    public abstract void makeSound();
    public abstract void describe();
    public void sleep() {
        System.out.println("Zzz");
    }
}

interface CanFly { // can-do: defines contract/capabilitiy
    void flying();
}

class Dog extends Animal {

    public String breed;

    public Dog(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("BARK!");
    }

    @Override
    public void describe() {
        System.out.println(String.format("I am a %s and i like to chase cats", breed));
    }

    public void play() {
        System.out.println("Roll in muds");
    }
}

class Cat extends Animal {

    public boolean likesLasagna;

    public Cat(boolean likesLasagna) {
        this.likesLasagna = likesLasagna;
    }

    @Override
    public void makeSound() {
        System.out.println("Meow");
    }

    @Override
    public void describe() {
        if (likesLasagna) {
            System.out.println("I love lasagna");
        } else {
            System.out.println("I love tuna");
        }
    }

}

class Bird extends Animal implements CanFly {

    public float wingWidth;

    public Bird(float wingWidth) {
        this.wingWidth = wingWidth;
    }

    @Override
    public void makeSound() {
        System.out.println("Chirp chirp!");
    }

    @Override
    public void describe() {
        System.out.println("Likes to eat worms and have wing width " + wingWidth + " feet");
    }

    @Override
    public void sleep() {
        System.out.println("<bird sleeping noise>");
    }

    @Override
    public void flying() {
        System.out.println("I can fly!");
    }
}